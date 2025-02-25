package me.sfiguz7.extratools.implementation.machines;

import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.sfiguz7.extratools.implementation.interfaces.ETInventoryBlock;
import me.sfiguz7.extratools.lists.ETItems;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class CobblestoneGenerator extends SimpleSlimefunItem<BlockTicker> implements ETInventoryBlock,
    EnergyNetComponent {

    private final int speed;
    private final int[] border = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 18, 19, 21, 22, 27, 28, 30,
        31, 36, 37, 38, 39, 40, 41, 42, 43, 44, 22};
    private final int[] inputBorder = {};
    private final int[] outputBorder = {14, 15, 16, 17, 23, 26, 32, 33, 34, 35};

    public CobblestoneGenerator(Tier tier) {
        super(ETItems.extra_tools, tier == Tier.ONE ? ETItems.COBBLESTONE_GENERATOR : (tier == Tier.TWO ? ETItems.COBBLESTONE_GENERATOR_2 : ETItems.COBBLESTONE_GENERATOR_3), RecipeType.ENHANCED_CRAFTING_TABLE, tier.recipe);
        this.speed = tier.speed;
        createPreset(this, this::constructMenu);

        addItemHandler(onBreak());
    }

    private void constructMenu(BlockMenuPreset preset) {
        for (int i : border) {
            preset.addItem(i, new CustomItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE), " "),
                ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : inputBorder) {
            preset.addItem(i, new CustomItem(new ItemStack(Material.CYAN_STAINED_GLASS_PANE), " "),
                ChestMenuUtils.getEmptyClickHandler());
        }
        for (int i : outputBorder) {
            preset.addItem(i, new CustomItem(new ItemStack(Material.ORANGE_STAINED_GLASS_PANE), " "),
                ChestMenuUtils.getEmptyClickHandler());
        }

        preset.addItem(11, new CustomItem(new ItemStack(Material.LAVA_BUCKET), " "),
                ChestMenuUtils.getEmptyClickHandler());
        preset.addItem(20, new CustomItem(new ItemStack(Material.COBBLESTONE), " "),
                ChestMenuUtils.getEmptyClickHandler());
        preset.addItem(29, new CustomItem(new ItemStack(Material.WATER_BUCKET), " "),
                ChestMenuUtils.getEmptyClickHandler());

        for (int i : getOutputSlots()) {
            preset.addMenuClickHandler(i, new ChestMenu.AdvancedMenuClickHandler() {

                @Override
                public boolean onClick(Player p, int slot, ItemStack cursor, ClickAction action) {
                    return false;
                }

                @Override
                public boolean onClick(InventoryClickEvent e, Player p, int slot, ItemStack cursor,
                                       ClickAction action) {
                    return cursor == null || cursor.getType() == Material.AIR;
                }
            });
        }
    }

    @Override
    public int[] getInputSlots() {
        return new int[] {};
    }

    @Override
    public int[] getOutputSlots() {
        return new int[] {24, 25};
    }

    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    @Override
    public int getCapacity() {
        return 512;
    }

    public int getEnergyConsumption() {
        return 60;
    }

    public BlockBreakHandler onBreak() {
        return (e, item, fortune, drops) -> {
            Block b = e.getBlock();
            BlockMenu inv = BlockStorage.getInventory(b);

            if (inv != null) {
                inv.dropItems(b.getLocation(), getInputSlots());
                inv.dropItems(b.getLocation(), getOutputSlots());
            }
            return true;
        };
    }

    @Override
    public BlockTicker getItemHandler() {
        return new BlockTicker() {
            @Override
            public void tick(Block b, SlimefunItem sf, Config data) {
                int spt = SlimefunPlugin.getTickerTask().getSPT();

                ItemStack output = new ItemStack(Material.COBBLESTONE, spt * speed);

                if (getCharge(b.getLocation()) >= getEnergyConsumption() * spt) {
                    BlockMenu menu = BlockStorage.getInventory(b);

                    if (!menu.fits(output, getOutputSlots())) {
                        return;
                    }

                    removeCharge(b.getLocation(), getEnergyConsumption() * spt);
                    menu.pushItem(output, getOutputSlots());
                }
            }

            @Override
            public boolean isSynchronized() {
                return true;
            }
        };
    }

    public enum Tier {
        ONE(new ItemStack[] {SlimefunItems.PROGRAMMABLE_ANDROID_MINER, SlimefunItems.MAGNESIUM_INGOT,
                        SlimefunItems.PROGRAMMABLE_ANDROID_MINER,
                        new ItemStack(Material.WATER_BUCKET), SlimefunItems.BLISTERING_INGOT,
                        new ItemStack(Material.LAVA_BUCKET),
                        SlimefunItems.PROGRAMMABLE_ANDROID_MINER, SlimefunItems.MEDIUM_CAPACITOR,
                        SlimefunItems.PROGRAMMABLE_ANDROID_MINER}, 1
        ),
        TWO(new ItemStack[] {ETItems.COBBLESTONE_GENERATOR, SlimefunItems.MAGNESIUM_INGOT,
                ETItems.COBBLESTONE_GENERATOR,
                new ItemStack(Material.WATER_BUCKET), SlimefunItems.BLISTERING_INGOT_2,
                new ItemStack(Material.LAVA_BUCKET),
                null, SlimefunItems.BIG_CAPACITOR,
                null}, 2
        ),
        THREE(new ItemStack[] {ETItems.COBBLESTONE_GENERATOR_2, SlimefunItems.MAGNESIUM_INGOT,
                ETItems.COBBLESTONE_GENERATOR_2,
                new ItemStack(Material.WATER_BUCKET), SlimefunItems.BLISTERING_INGOT_3,
                new ItemStack(Material.LAVA_BUCKET),
                null, SlimefunItems.LARGE_CAPACITOR,
                null}, 4
        );

        private final ItemStack[] recipe;
        private final int speed;

        Tier(ItemStack[] recipe, int speed) {
            this.recipe = recipe;
            this.speed = speed;
        }
    }

}

