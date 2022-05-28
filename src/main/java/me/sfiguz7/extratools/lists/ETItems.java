package me.sfiguz7.extratools.lists;

import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import me.sfiguz7.extratools.ExtraTools;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public final class ETItems {

    /* Category */
    public static final Category extra_tools = new Category(new NamespacedKey(ExtraTools.getInstance(),
        "extra_tools"),
        new CustomItem(Material.DIAMOND_AXE, "&b更多工具")
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
        new CustomItem(SkullItem.fromHash("acb060ebfb1fd99982f1719cf27a929ac9ce131adbc8de472c9b83d719bcbed9")),
        "&6黃金轉換器",
        "",
        LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
        LoreBuilder.powerBuffer(256),
        LoreBuilder.powerPerSecond(18)
    );
    public static final SlimefunItemStack ELECTRIC_COMPOSTER = new SlimefunItemStack("ELECTRIC_COMPOSTER",
        new CustomItem(SkullItem.fromHash("7db43bd87e22876ff853b16f9d32ce670cf7e5d2a8dc0b7f7e93569eb5a9bc17")),
        "&c電動攪拌機",
        "",
        LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
        "&8\u21E8 &7速度: 1x",
        LoreBuilder.powerBuffer(256),
        LoreBuilder.powerPerSecond(18)
    );
    public static final SlimefunItemStack ELECTRIC_COMPOSTER_2 = new SlimefunItemStack("ELECTRIC_COMPOSTER_2",
        new CustomItem(SkullItem.fromHash("7db43bd87e22876ff853b16f9d32ce670cf7e5d2a8dc0b7f7e93569eb5a9bc17")),
        "&c電動攪拌機 &7- &eII",
        "",
        LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
        "&8\u21E8 &7速度: 4x",
        LoreBuilder.powerBuffer(256),
        LoreBuilder.powerPerSecond(50)
    );
    public static final SlimefunItemStack COBBLESTONE_GENERATOR = new SlimefunItemStack("COBBLESTONE_GENERATOR",
        new CustomItem(SkullItem.fromHash("54e4e42f36339a59de4ee9bf21224cc446db8cec17565728b16602050d2a737")),
        "&c鵝卵石生成器",
        "",
        LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            "&8\u21E8 &7速度: 1x",
        LoreBuilder.powerBuffer(256),
        LoreBuilder.powerPerSecond(50)
    );

    public static final SlimefunItemStack COBBLESTONE_GENERATOR_2 = new SlimefunItemStack("COBBLESTONE_GENERATOR_2",
        new CustomItem(SkullItem.fromHash("54e4e42f36339a59de4ee9bf21224cc446db8cec17565728b16602050d2a737")),
        "&c鵝卵石生成器 &7- &eII",
        "",
        LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            "&8\u21E8 &7速度: 2x",
        LoreBuilder.powerBuffer(512),
        LoreBuilder.powerPerSecond(108)
    );

    public static final SlimefunItemStack COBBLESTONE_GENERATOR_3 = new SlimefunItemStack("COBBLESTONE_GENERATOR_3",
        new CustomItem(SkullItem.fromHash("54e4e42f36339a59de4ee9bf21224cc446db8cec17565728b16602050d2a737")),
        "&c鵝卵石生成器 &7- &eIII",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            "&8\u21E8 &7速度: 4x",
        LoreBuilder.powerBuffer(1024),
        LoreBuilder.powerPerSecond(240)
    );

    public static final SlimefunItemStack VAPORIZER = new SlimefunItemStack("VAPORIZER",
        new CustomItem(SkullItem.fromHash("d9b1e478e69c8912edb73a433d7ad856224efda21e35166fb75b29a17c237f9f")),
        "&c蒸餾機",
        "",
        LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
        LoreBuilder.powerBuffer(256),
        LoreBuilder.powerPerSecond(32)
    );
    public static final SlimefunItemStack CONCRETE_FACTORY = new SlimefunItemStack("CONCRETE_FACTORY",
        new CustomItem(SkullItem.fromHash("2481e6f7369cdb29dc0702372e5a4dfdb9875ee6aced87b701f81999c0fdd195")),
        "&4混凝土工廠",
        "",
        LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
        LoreBuilder.powerBuffer(256),
        LoreBuilder.powerPerSecond(16)
    );
    public static final SlimefunItemStack PULVERIZER = new SlimefunItemStack("PULVERIZER",
        new CustomItem(SkullItem.fromHash("8e255fe2bc8ffd0373dfefa0a7127bac064685c131585349bcd9b7dc60d1f00b")),
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