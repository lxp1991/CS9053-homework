package edu.nyu.cs9053.homework6;

/**
 * User: blangel
 * Date: 10/5/14
 * Time: 6:57 PM
 */
public class Population {

    // will be created by first running - java edu.nyu.cs9053.homework6.SpreadEpidemic


    @Infection(cause = Disease.SmallPox) public String getInfectedSmallPox() {
        return "bb364bf9-d5b0-471b-b80a-95bdecfa90171001e89438a6-ab4b-44ab-a7aa-54e2152a4091dda00763-58e2-42c5-b12e-5b557c5469f7";
    }

    @Infection(cause = Disease.Ebola) public String getInfectedEbola() {
        return "5ae82758-eeba-47e3-a751-2aacccbcfab11110a5361b83-9c0d-4570-a842-068315961e092fbcc460-9f3b-4cfa-bbd4-2e3e4075160f";
    }

    @Infection(cause = Disease.Sars) public String getInfectedSars() {
        return "d5441d77-7f99-4da8-9f64-dd965d94362810110841ee16-cc0d-47ef-96d5-eaa89488a614344f0bb7-35ea-4ee6-ae5d-b6fd35da2368";
    }

    @Infection(cause = Disease.H1N1) public String getInfectedH1N1() {
        return "8b7d4067-ae1f-4342-a8fa-3f9e9ae6818d010011001110101110106ab98072-1296-440a-9a85-4e0937c161e29db33685-4ffa-41b1-90b8-6c047e581e2d";
    }


}
