package me.sfiguz7.extratools.lists;

import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.sfiguz7.extratools.ExtraTools;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public final class ETItems {

    /* Category */
    public static final Category extra_tools = new Category(new NamespacedKey(ExtraTools.getInstance(),
        "extra_tools"),
        new CustomItem(Material.DIAMOND_AXE, "&4更多工具")
    );
    /* Items */
    public static final SlimefunItemStack HAMMER = new SlimefunItemStack("HAMMER",
        Material.IRON_PICKAXE,
        "&c鎚子",
        "",
        "&9直接粉碎方塊"
    );
    /* Machines */
    public static final SlimefunItemStack GOLD_TRANSMUTER = new SlimefunItemStack("GOLD_TRANSMUTER",
        Material.YELLOW_TERRACOTTA,
        "&6黃金轉換器",
        "",
        LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
        LoreBuilder.powerBuffer(256),
        LoreBuilder.powerPerSecond(18)
    );
    public static final SlimefunItemStack ELECTRIC_COMPOSTER = new SlimefunItemStack("ELECTRIC_COMPOSTER",
        Material.MAGENTA_TERRACOTTA,
        "&c電動堆肥機",
        "",
        LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
        "&8\u21E8 &7速度: 1x",
        LoreBuilder.powerBuffer(256),
        LoreBuilder.powerPerSecond(18)
    );
    public static final SlimefunItemStack ELECTRIC_COMPOSTER_2 = new SlimefunItemStack("ELECTRIC_COMPOSTER_2",
        Material.MAGENTA_TERRACOTTA,
        "&c電動堆肥機 &7- &eII",
        "",
        LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
        "&8\u21E8 &7速度: 4x",
        LoreBuilder.powerBuffer(256),
        LoreBuilder.powerPerSecond(50)
    );
    public static final SlimefunItemStack COBBLESTONE_GENERATOR = new SlimefunItemStack("COBBLESTONE_GENERATOR",
        Material.POLISHED_ANDESITE,
        "&c鵝卵石生成器",
        "",
        LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
        LoreBuilder.powerBuffer(256),
        LoreBuilder.powerPerSecond(36)
    );
    public static final SlimefunItemStack VAPORIZER = new SlimefunItemStack("VAPORIZER",
        Material.RED_STAINED_GLASS,
        "&c蒸餾機",
        "",
        LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
        LoreBuilder.powerBuffer(256),
        LoreBuilder.powerPerSecond(32)
    );
    public static final SlimefunItemStack CONCRETE_FACTORY = new SlimefunItemStack("CONCRETE_FACTORY",
        Material.BLACK_CONCRETE,
        "&4混凝土工廠",
        "",
        LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
        LoreBuilder.powerBuffer(256),
        LoreBuilder.powerPerSecond(16)
    );
    public static final SlimefunItemStack PULVERIZER = new SlimefunItemStack("PULVERIZER",
        Material.ORANGE_TERRACOTTA,
        "&c粉碎機",
        "",
        LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
        "&8\u21E8 &7速度: 1x",
        LoreBuilder.powerBuffer(256),
        LoreBuilder.powerPerSecond(18)
    );
    private ETItems() {
    }
}