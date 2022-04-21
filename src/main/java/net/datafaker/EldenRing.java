package net.datafaker;

public class EldenRing {
    private final Faker faker;

    protected EldenRing(Faker faker) {
        this.faker = faker;
    }

    public String location() {
        return faker.resolve("elden_ring.location");
    }

    public String weapon() {
        return faker.resolve("elden_ring.weapon");
    }

    public String skill(){
        return faker.resolve("elden_ring.skill");
    }

    public String spell(){
        return faker.resolve("elden_ring.spell");
    }

    public String NPC(){
        return faker.resolve("elden_ring.NPC");
    }
}
