package com.testexamples.busfaredetails;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FareCalculator {
    static Map<Integer,BusFareDetails> fareDetails=new HashMap<>();
    static{
        fareDetails.put(1,new BusFareDetails(1,"H.S.R. Layout",0));
        fareDetails.put(2,new BusFareDetails(2,"Madiwala",5));
        fareDetails.put(3,new BusFareDetails(3,"Forum",11));
        fareDetails.put(4,new BusFareDetails(4,"Shanthinagara",15));
        fareDetails.put(5,new BusFareDetails(5,"Richmond Circle",18));
        fareDetails.put(6,new BusFareDetails(6,"Chancery Pavillion",23));
        fareDetails.put(7,new BusFareDetails(7,"Bowring Institute",25));
        fareDetails.put(8,new BusFareDetails(8,"Bangalore Club",27));
        fareDetails.put(9,new BusFareDetails(9,"Indian Express",29));
        fareDetails.put(10,new BusFareDetails(10,"Vasantanagara",30));
        fareDetails.put(11,new BusFareDetails(11,"RM Guttahalli",33));
        fareDetails.put(12,new BusFareDetails(12,"Mekhri Circle",35));
        fareDetails.put(13,new BusFareDetails(13,"Hebbala",37));
        fareDetails.put(14,new BusFareDetails(14,"BIAL",62));
    }

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter Source and Destination Route Numbers in  SOURCE_BUS_ROUTE_NO>TARGET_BUS_ROUTE_NO  format:");
            String input =br.readLine();
            //String input = "7>12";
            // String input = "1>10";
            if(input == null){
                System.out.println("Please provide valid input");
            }else{
                String[] routeArr = input.split(">");
                if(routeArr.length<=1) {
                    System.out.println("Please provide Source Route and Destination in SOURCE_BUS_ROUTE_NO>TARGET_BUS_ROUTE_NO format");
                }else{
                    int srcRouteNo = Integer.parseInt(routeArr[0]);
                    int destRouteNo = Integer.parseInt(routeArr[1]);

                    if(destRouteNo-srcRouteNo<0){
                        System.out.println("Please provide valid Route details. Distance should not be negative.");
                    }else if((srcRouteNo<1 || srcRouteNo>14) || (destRouteNo<1 || destRouteNo>14)){
                        System.out.println("Route Numbers should be between 1 and 14");
                    }else{
                        String busFareDetails = calculateFare(srcRouteNo,destRouteNo);
                        System.out.println(busFareDetails);
                    }
                }

            }
        }catch(Exception e){
            System.out.println("Something went wrong. Please check the details provided.");

        }
    }

    public static String calculateFare(int sourceRoute, int destinationRoute){
        //System.out.println("SOURCE ROUTE ID >> "+sourceRoute);
        //System.out.println("DESTINATION ROUTE ID >> "+destinationRoute);

        BusFareDetails SourceFareDetails = fareDetails.get(sourceRoute);
        BusFareDetails DestinationFareDetails = fareDetails.get(destinationRoute);
        //System.out.println("SourceFareDetails ::: "+SourceFareDetails.getKiloMeters());
        //System.out.println("DestinationFareDetails ::: "+DestinationFareDetails.getKiloMeters());

        int totalDistanceTravelled = DestinationFareDetails.getKiloMeters()-SourceFareDetails.getKiloMeters();

        //System.out.println("TOTAL DISTANCE BETWEEN ROUTES >> "+totalDistanceTravelled);

        int initialDistance = 3;
        int secondDistance = ((totalDistanceTravelled-3)>=20?19:(totalDistanceTravelled-3));
        int thirdDistance = (initialDistance+secondDistance)<22?0:(totalDistanceTravelled-24);//24 = 3(initial) + 20(second) + 1 (third need to exclude)
        //System.out.println("Initial Dis :: "+initialDistance+"\nSecond Dist :: "+secondDistance+"\nthirdDistance :: "+thirdDistance);
        int totalFare = initialDistance+secondDistance*2+thirdDistance*1;
        //System.out.println("TOTAL FARE :: "+totalFare);

        return (SourceFareDetails.getBusName()+" > "+DestinationFareDetails.getBusName()+" = Rs. "+totalFare);
    }
}
