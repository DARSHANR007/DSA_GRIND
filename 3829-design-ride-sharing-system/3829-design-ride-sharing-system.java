class RideSharingSystem {
Queue<Integer> driver;
    Queue<Integer> rider;

    public RideSharingSystem() {
        this.driver = new LinkedList<>();
        this.rider = new LinkedList<>();
    }
    
    public void addRider(int riderId) {

        rider.add(riderId);
        
    }
    
    public void addDriver(int driverId) {
    
    driver.add(driverId);
        
    }
    
    public int[] matchDriverWithRider() {

        if( driver.peek()!=null && rider.peek()!=null){
            return new int[]{driver.poll(),rider.poll()};
        }

        return new int[]{-1,-1};
        
    }
    
    public void cancelRider(int riderId) {

        if(rider.contains(riderId)){
            rider.remove(riderId);        }
        
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */