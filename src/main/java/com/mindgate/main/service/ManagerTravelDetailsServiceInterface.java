package com.mindgate.main.service;

public interface ManagerTravelDetailsServiceInterface {


    public boolean managerApprovedTravelRequestDetails(String travelRequestId);

     public boolean managerRejectedTravelRequestDetails (String travelRequestId);
}
