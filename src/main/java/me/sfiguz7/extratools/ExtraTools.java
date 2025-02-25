package me.sfiguz7.extratools;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.core.researching.Research;
import me.sfiguz7.extratools.implementation.machines.CobblestoneGenerator;
import me.sfiguz7.extratools.implementation.machines.ConcreteFactory;
import me.sfiguz7.extratools.implementation.machines.ElectricComposter;
import me.sfiguz7.extratools.implementation.machines.GoldTransmuter;
import me.sfiguz7.extratools.implementation.machines.Pulverizer;
import me.sfiguz7.extratools.implementation.machines.Vaporizer;
import me.sfiguz7.extratools.implementation.tools.Hammer;
import me.sfiguz7.extratools.lists.ETItems;
import org.bstats.bukkit.Metrics;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ExtraTools extends JavaPlugin implements SlimefunAddon {

    public static ExtraTools instance;
    private int researchId = 4100;

    @Override
    public void onEnable() {

        instance = this;

        if (!new File(getDataFolder(), "config.yml").exists()) {
            saveDefaultConfig();
        }

        int bStatsId = 6945;
        new Metrics(this, bStatsId);


        new Hammer().register(this);
        new Research(new NamespacedKey(this, "HAMMER"),
            ++researchId, "鎚子", 3)
            .addItems(ETItems.HAMMER).register();

        new GoldTransmuter().register(this);
        new Research(new NamespacedKey(this, "GOLD_TRANSMUTER"),
            ++researchId, "黃金轉換器", 12)
            .addItems(ETItems.GOLD_TRANSMUTER).register();

        new ElectricComposter(ElectricComposter.Tier.ONE) {

            @Override
            public int getEnergyConsumption() {
                return 9;
            }

            @Override
            public int getSpeed() {
                return 1;
            }

        }.register(this);
        new Research(new NamespacedKey(this, "ELECTRIC_COMPOSTER"),
            ++researchId, "電力攪拌機", 18)
            .addItems(ETItems.ELECTRIC_COMPOSTER).register();

        new ElectricComposter(ElectricComposter.Tier.TWO) {

            @Override
            public int getEnergyConsumption() {
                return 25;
            }

            @Override
            public int getSpeed() {
                return 4;
            }

        }.register(this);
        new Research(new NamespacedKey(this, "ELECTRIC_COMPOSTER_2"),
            ++researchId, "電力攪拌機 II", 18)
            .addItems(ETItems.ELECTRIC_COMPOSTER_2).register();

        new CobblestoneGenerator(CobblestoneGenerator.Tier.ONE) {
            @Override
            public int getEnergyConsumption() {
                return 60;
            }

            @Override
            public int getCapacity() {
                return 256;
            }

        }.register(this);
        new Research(new NamespacedKey(this, "COBBLESTONE_GENERATOR"),
            ++researchId, "鵝卵石生成器", 30)
            .addItems(ETItems.COBBLESTONE_GENERATOR).register();

        new CobblestoneGenerator(CobblestoneGenerator.Tier.TWO) {
            @Override
            public int getEnergyConsumption() {
                return 100;
            }

            @Override
            public int getCapacity() {
                return 512;
            }

        }.register(this);
        new Research(new NamespacedKey(this, "COBBLESTONE_GENERATOR_2"),
                ++researchId, "鵝卵石生成器 II", 40)
                .addItems(ETItems.COBBLESTONE_GENERATOR_2).register();

        new CobblestoneGenerator(CobblestoneGenerator.Tier.THREE) {
            @Override
            public int getEnergyConsumption() {
                return 192;
            }

            @Override
            public int getCapacity() {
                return 1024;
            }

        }.register(this);
        new Research(new NamespacedKey(this, "COBBLESTONE_GENERATOR_3"),
                ++researchId, "鵝卵石生成器 III", 60)
                .addItems(ETItems.COBBLESTONE_GENERATOR_3).register();

        new Vaporizer().register(this);
        new Research(new NamespacedKey(this, "VAPORIZER"),
            ++researchId, "蒸餾機", 18)
            .addItems(ETItems.VAPORIZER).register();

        new ConcreteFactory().register(this);
        new Research(new NamespacedKey(this, "CONCRETE_FACTORY"),
            ++researchId, "混凝土工廠", 12)
            .addItems(ETItems.CONCRETE_FACTORY).register();

        new Pulverizer().register(this);
        new Research(new NamespacedKey(this, "PULVERIZER"),
            ++researchId, "粉碎機", 18)
            .addItems(ETItems.PULVERIZER).register();

    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/Sfiguz7/ExtraTools/issues";
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    public static ExtraTools getInstance() {
        return instance;
    }

}
