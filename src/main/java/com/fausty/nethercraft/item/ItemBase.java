package com.fausty.nethercraft.item;

import com.fausty.nethercraft.tab.Tabs;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

public class ItemBase extends Item {

    protected IIcon[] textures;

    public ItemBase(String internalName) {
        super();
        this.setUnlocalizedName(internalName);
        this.setCreativeTab(Tabs.NETHERCRAFT);
        GameRegistry.registerItem(this, internalName);
    }

    public String getTextureFolder() {
        return null;
    }

    public String getTextureName(int index) {
        if (!this.hasSubtypes && index > 0) {
            return null;
        }
        final String name = this.getUnlocalizedName(new ItemStack(this, 1, index));
        if (name != null && name.length() > 4) {
            return name.substring(5, name.length() - 5);
        }
        return name;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        int indexCount = 0;
        while (this.getTextureName(indexCount) != null) {
            if (++indexCount > 32767) {
                throw new RuntimeException("More Item Icons than actually possible @ " + this.getUnlocalizedName());
            }
        }
        this.textures = new IIcon[indexCount];
        final String textureFolder = (this.getTextureFolder() == null) ? "" : (this.getTextureFolder() + "/");
        for (int index = 0; index < indexCount; ++index) {
            this.textures[index] = iconRegister.registerIcon("nethercraft:" + textureFolder + this.getTextureName(index));
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        if (meta < this.textures.length) {
            return this.textures[meta];
        }
        return (this.textures.length < 1) ? null : this.textures[0];
    }

    public String getUnlocalizedName() {
        return super.getUnlocalizedName() + ".name";
    }

    public String getUnlocalizedName(ItemStack itemStack) {
        return this.getUnlocalizedName();
    }

    public String getItemStackDisplayName(ItemStack itemStack) {
        return StatCollector.translateToLocal(this.getUnlocalizedName(itemStack));
    }

}
