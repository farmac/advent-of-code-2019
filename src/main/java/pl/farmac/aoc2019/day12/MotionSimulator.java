package pl.farmac.aoc2019.day12;

public class MotionSimulator {
    private Moon[] moons;
    
    public MotionSimulator(Moon[] moons) {
        this.moons = moons;
    }
    
    public long findNumberOfStepsUntilAllMoonsAreInTheSamePositionAgain() {
        long repeatX = 0;
        long repeatY = 0;
        long repeatZ = 0;
        long i = 0;
        Moon[] moons1 = Main.parseInput();
        
        boolean xDone = false;
        boolean yDone = false;
        boolean zDone = false;
        
        do {
            boolean x = true;
            boolean y = true;
            boolean z = true;
            doOneTick();
            i++;
            for (int j = 0; j < moons.length && !xDone; j++) {
                if (moons1[j].getPosX() != moons[j].getPosX() ||
                        moons1[j].getVelX() != moons[j].getVelX()) {
                    x = false;
                    break;
                }
            }
            for (int j = 0; j < moons.length && !yDone; j++) {
                if (moons1[j].getPosY() != moons[j].getPosY() ||
                        moons1[j].getVelY() != moons[j].getVelY()) {
                    y = false;
                    break;
                }
            }
            for (int j = 0; j < moons.length && !zDone; j++) {
                if (moons1[j].getPosZ() != moons[j].getPosZ() ||
                        moons1[j].getVelZ() != moons[j].getVelZ()) {
                    z = false;
                    break;
                }
            }
            if (x && !xDone) {
                repeatX = i;
                xDone = true;
            }
            if (y && !yDone) {
                repeatY = i;
                yDone = true;
            }
            if (z && !zDone) {
                repeatZ = i;
                zDone = true;
            }
            
        } while (!zDone || !xDone || !yDone);
        return leastCommonMultiple(repeatX, repeatY, repeatZ);
    }
    
    public void simulateMotion(int number) {
        for (int i = 0; i < number; i++) {
            doOneTick();
        }
    }
    
    public int getTotalEnergy() {
        int totalEnergy = 0;
        for (Moon moon : moons) {
            totalEnergy += moon.getTotalEnergy();
        }
        return totalEnergy;
    }
    
    private void doOneTick() {
        for (int i = 0; i < moons.length; i++) {
            for (int j = 0; j < moons.length; j++) {
                if (i == j) {
                    continue;
                }
                if (moons[i].getPosX() < moons[j].getPosX()) {
                    moons[i].incVelX();
                } else if (moons[i].getPosX() > moons[j].getPosX()) {
                    moons[i].decVelX();
                }
                
                if (moons[i].getPosY() < moons[j].getPosY()) {
                    moons[i].incVelY();
                } else if (moons[i].getPosY() > moons[j].getPosY()) {
                    moons[i].decVelY();
                }
                
                if (moons[i].getPosZ() < moons[j].getPosZ()) {
                    moons[i].incVelZ();
                } else if (moons[i].getPosZ() > moons[j].getPosZ()) {
                    moons[i].decVelZ();
                }
            }
        }
        moons[0].applyVelocity();
        moons[1].applyVelocity();
        moons[2].applyVelocity();
        moons[3].applyVelocity();
    }
    
    private long leastCommonMultiple(long x, long y, long z) {
        long gcdForXandY = gcd(x, y);
        long lcmForXAndY = x * y / gcdForXandY;
        
        long gcdForAllThreeNumbers = gcd(lcmForXAndY, z);
        return lcmForXAndY * z / gcdForAllThreeNumbers;
        
    }
    
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
