public class WipingStationV2 implements Wiping {

    @Override
    public void wipMirrors() {
        System.out.println("Помывка зеркал");
    }

    @Override
    public void wipWindshield() {
        System.out.println("Протирка лобового стекла");
    }

    @Override
    public void wipHeadlights() {
        System.out.println("Протирка фар");
    }
    
}
