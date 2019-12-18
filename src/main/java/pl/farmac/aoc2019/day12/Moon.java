package pl.farmac.aoc2019.day12;


public class Moon {
    private int posX;
    private int posY;
    private int posZ;
    private int velX;
    private int velY;
    private int velZ;
    
    public Moon(int posX, int posY, int posZ) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }
    
    public int getVelX() {
        return velX;
    }
    
    public int getVelY() {
        return velY;
    }
    
    public int getVelZ() {
        return velZ;
    }
    
    public void incVelX() {
        velX++;
    }
    
    public void incVelY() {
        velY++;
    }
    
    public void incVelZ() {
        velZ++;
    }
    
    public void decVelX() {
        velX--;
    }
    
    public void decVelY() {
        velY--;
    }
    
    public void decVelZ() {
        velZ--;
    }
    
    void applyVelocity() {
        posX += velX;
        posY += velY;
        posZ += velZ;
    }
    
    public int getPosX() {
        return posX;
    }
    
    public int getPosY() {
        return posY;
    }
    
    public int getPosZ() {
        return posZ;
    }
    
    private int getPotentialEnergy() {
        return Math.abs(posX) + Math.abs(posY) + Math.abs(posZ);
    }
    
    private int getKineticEnergy() {
        return Math.abs(velX) + Math.abs(velY) + Math.abs(velZ);
    }
    
    public int getTotalEnergy() {
        return getKineticEnergy() * getPotentialEnergy();
    }
}
