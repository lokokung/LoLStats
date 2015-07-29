package riotapi.staticdata.champion;

public class InfoDto {
    private int attack;
    private int defense;
    private int difficulty;
    private int magic;

    public int get_attack() {
        return attack;
    }

    public void set_attack(int attack) {
        this.attack = attack;
    }

    public int get_defense() {
        return defense;
    }

    public void set_defense(int defense) {
        this.defense = defense;
    }

    public int get_difficulty() {
        return difficulty;
    }

    public void set_difficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int get_magic() {
        return magic;
    }

    public void set_magic(int magic) {
        this.magic = magic;
    }
}