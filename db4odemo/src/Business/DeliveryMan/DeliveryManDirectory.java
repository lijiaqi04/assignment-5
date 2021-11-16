/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DeliveryMan;

import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class DeliveryManDirectory {
    ArrayList<DeliveryMan> deliveryManArrayList;

    public DeliveryManDirectory() {
        deliveryManArrayList=new ArrayList<>();
    }
    public ArrayList<DeliveryMan> getDeliveryManArrayList() {
        return deliveryManArrayList;
    }
    public DeliveryMan createDeliverMan(String name){
        DeliveryMan deliveryMan =new DeliveryMan();
        deliveryMan.setName(name);
        deliveryManArrayList.add(deliveryMan);
        return deliveryMan;
    }
}
