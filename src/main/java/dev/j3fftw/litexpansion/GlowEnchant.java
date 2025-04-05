package dev.j3fftw.litexpansion;

import com.google.common.base.Preconditions;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class GlowEnchant extends Enchantment {

    private final Set<String> ids = new HashSet<>();
    private final NamespacedKey key;

    public GlowEnchant(@Nonnull NamespacedKey key, @Nonnull String[] applicableItems) {
        this.key = key;
        ids.addAll(Arrays.asList(applicableItems));
    }

    @Nonnull
    @Override
    @Deprecated
    public String getName() {
        return "LX_Glow";
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Nonnull
    @Override
    @Deprecated
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.ALL;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    @Deprecated
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(@Nonnull Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        if (item.hasItemMeta()) {
            final ItemMeta itemMeta = item.getItemMeta();
            Preconditions.checkNotNull(itemMeta, "can not be null");
            final Optional<String> id = Slimefun.getItemDataService().getItemData(itemMeta);

            if (id.isPresent()) {
                return ids.contains(id.get());
            }
        }
        return false;
    }

    
    /**
     * This method is AI-generated.
     */
    @Nonnull
    @Override
    public NamespacedKey getKey() {
        return this.key;
    }

     /**
     * This method is AI-generated.
     */
    @Override
    public NamespacedKey getKeyOrNull() {
        return this.key;
    }

     /**
     * This method is AI-generated.
     */
    @Override
    public NamespacedKey getKeyOrThrow() {
        if (this.key == null) {
            throw new IllegalStateException("Key not set for this enchantment instance");
        }
        return this.key;
    }

     /**
     * This method is AI-generated.
     */
    @Nonnull
    @Override
    public String getTranslationKey() {
        return "enchantment." + this.key.getNamespace() + "." + this.key.getKey();
    }

     /**
     * This method is AI-generated.
     */
    @Override
    public boolean isRegistered() {
        Enchantment registeredEnchantment = Registry.ENCHANTMENT.get(this.key);
        return registeredEnchantment != null && registeredEnchantment == this;
    }
}
