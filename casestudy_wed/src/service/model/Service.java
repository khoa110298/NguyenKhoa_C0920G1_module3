package service.model;

public class Service {
    private String serviceId;
    private String serviceName;
    private String serviceAre;
    private String serviceCost;
    private String serviceMaxPeople;
    private String rentTypeId;
    private String serviceTypeId;
    private String standRoom;
    private String poolArea;
    private String numberFloor;

    public Service() {
    }

    public Service(String serviceId, String serviceName, String serviceAre, String serviceCost, String serviceMaxPeople, String rentTypeId, String serviceTypeId, String standRoom, String poolArea, String numberFloor) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceAre = serviceAre;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standRoom = standRoom;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceAre() {
        return serviceAre;
    }

    public void setServiceAre(String serviceAre) {
        this.serviceAre = serviceAre;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(String rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(String serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getStandRoom() {
        return standRoom;
    }

    public void setStandRoom(String standRoom) {
        this.standRoom = standRoom;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(String numberFloor) {
        this.numberFloor = numberFloor;
    }
}
