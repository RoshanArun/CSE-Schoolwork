import java.util.ArrayList;
import java.util.List;

class DevManagement {
    private List<Dev> devs;

    public DevManagement() {
        this.devs = new ArrayList<>();
    }

    public void addDev(Dev dev) {
        devs.add(dev);
    }

    public Dev getDevByName(String devName) {
        for (Dev dev : devs) {
            if (dev.getDevName().equals(devName)) {
                return dev;
            }
        }
        return null;
    }
}
