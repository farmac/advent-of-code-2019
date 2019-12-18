package pl.farmac.aoc2019.day12;

public class MotionSimulator {
    private Moon[] moons;
    
    public MotionSimulator(Moon[] moons) {
        this.moons = moons;
    }
    
    public void simulateMotion(int number) {
        for (int i = 0; i < number; i++) {
            doOneMotion();
        }
    }
    public int getTotalEnergy() {
        int totalEnergy = 0;
        for (Moon moon : moons) {
            totalEnergy += moon.getTotalEnergy();
        }
        return totalEnergy;
    }
    private void doOneMotion() {
        for (int i = 0; i < moons.length; i++) {
            for (int j = 0; j < moons.length; j++) {
                if(i == j) {
                    continue;
                }
                if(moons[i].getPosX() < moons[j].getPosX()) {
                    moons[i].incVelX();
                } else if(moons[i].getPosX() > moons[j].getPosX()) {
                    moons[i].decVelX();
                }
    
                if(moons[i].getPosY() < moons[j].getPosY()) {
                    moons[i].incVelY();
                } else if(moons[i].getPosY() > moons[j].getPosY()) {
                    moons[i].decVelY();
                }
    
                if(moons[i].getPosZ() < moons[j].getPosZ()) {
                    moons[i].incVelZ();
                } else if(moons[i].getPosZ() > moons[j].getPosZ()) {
                    moons[i].decVelZ();
                }
            }
        }
        moons[0].applyVelocity();
        moons[1].applyVelocity();
        moons[2].applyVelocity();
        moons[3].applyVelocity();
    }
}
