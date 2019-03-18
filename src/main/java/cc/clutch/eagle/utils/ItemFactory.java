package cc.clutch.eagle.utils;

import com.google.common.collect.Lists;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;

public class ItemFactory implements Listener {

    private final ItemStack is;

    public ItemFactory(Material mat) {
        this.is = new ItemStack(mat);
    }

    public ItemFactory(ItemStack is) {
        this.is = is;
    }

    public ItemFactory amount(int amount) {
        this.is.setAmount(amount);
        return this;
    }

    public ItemFactory name(String name) {
        ItemMeta meta = this.is.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        this.is.setItemMeta(meta);
        return this;
    }

    public ItemFactory lore(String name) {
        ItemMeta meta = this.is.getItemMeta();
        ArrayList<String> lore = (ArrayList<String>) meta.getLore();
        if (lore == null) {
            lore = new ArrayList<>();
        }
        lore.add(name);
        meta.setLore(lore);
        this.is.setItemMeta(meta);
        return this;
    }

    public ItemFactory lore(List<String> lore) {
        ArrayList<String> toSet = new ArrayList<>();
        ItemMeta meta = this.is.getItemMeta();
        for (String string : lore) {
            toSet.add(ChatColor.translateAlternateColorCodes('&', string));
        }
        meta.setLore(toSet);
        this.is.setItemMeta(meta);
        return this;
    }

    public ItemFactory durability(int durability) {
        this.is.setDurability((short) durability);
        return this;
    }

    public ItemFactory data(int data) {
        this.is.setData(new MaterialData(this.is.getType(), (byte) data));
        return this;
    }

    public ItemFactory enchantment(Enchantment enchantment, int level) {
        this.is.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public ItemFactory enchantment(Enchantment enchantment) {
        this.is.addUnsafeEnchantment(enchantment, 1);
        return this;
    }

    public ItemFactory type(Material material) {
        this.is.setType(material);
        return this;
    }

    public ItemFactory clearLore() {
        ItemMeta meta = this.is.getItemMeta();
        meta.setLore(Lists.newArrayList());
        this.is.setItemMeta(meta);
        return this;
    }

    public ItemFactory clearEnchantments() {
        for (Enchantment e : this.is.getEnchantments().keySet()) {
            this.is.removeEnchantment(e);
        }
        return this;
    }

    public ItemFactory color(Color color) {
        if (this.is.getType() == Material.LEATHER_BOOTS || this.is.getType() == Material.LEATHER_CHESTPLATE || this.is.getType() == Material.LEATHER_HELMET || this.is.getType() == Material.LEATHER_LEGGINGS) {
            LeatherArmorMeta meta = (LeatherArmorMeta) this.is.getItemMeta();
            meta.setColor(color);
            this.is.setItemMeta(meta);
            return this;
        }
        throw new IllegalArgumentException("color() only applicable for leather armor!");
    }

    public ItemStack build() {
        return this.is;
    }
}