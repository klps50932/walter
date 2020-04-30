package com.example.coyi.walter;

import java.io.Serializable;

/**
 * Created by coyi on 2017/12/18.
 */

public class Item implements Serializable {
    private long id;
    private long login;
    private String name;
    private long weight;
    private long examount;
    private long money;
    private long waternow;
    private long waterday;
    private long wateraccu;
    private long walknow;
    private long walkday;
    private long good1;
    private long good2;
    private long good3;
    private long good4;
    private long good5;
    private long good6;
    private long good7;
    private long good8;
    private long experience;
    private long pet;
    private long ach1;
    private long achievement1;
    private long ach2;




    public Item(){
        name = "";

    }

    public Item(long id, long login, String name, long weight, long examount, long money, long waternow, long waterday, long wateraccu, long walknow, long walkday, long good1
    , long good2, long good3, long good4, long good5, long good6, long good7, long good8, long experience, long pet, long ach1, long achievement1, long ach2) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.weight = weight;
        this.examount = examount;
        this.money = money;
        this.waternow = waternow;
        this.waterday = waterday;
        this.wateraccu = wateraccu;
        this.walknow = walknow;
        this.walkday = walkday;
        this.good1 = good1;
        this.good2 = good2;
        this.good3 = good3;
        this.good4 = good4;
        this.good5 = good5;
        this.good6 = good6;
        this.good7 = good7;
        this.good8 = good8;
        this.experience = experience;
        this.pet = pet;
        this.ach1 = ach1;
        this.achievement1 = achievement1;
        this.ach2 = ach2;

    }

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return this.id;
    }

    public void setLogin(long login) {
        this.login = login;
    }
    public long getLogin() {
        return this.login;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }
    public long getWeight() {
        return this.weight;
    }

    public void setExamount(long examount) {
        this.examount = examount;
    }
    public long getExamount() {
        return this.examount;
    }

    public void setMoney(long money) {
        this.money = money;
    }
    public long getMoney() {
        return this.money;
    }

    public void setWaternow(long waternow) {
        this.waternow = waternow;
    }
    public long getWaternow() {
        return this.waternow;
    }

    public void setWaterday(long waterday) {
        this.waterday = waterday;
    }
    public long getWaterday() {
        return this.waterday;
    }

    public void setWateraccu(long wateraccu) {
        this.wateraccu = wateraccu;
    }
    public long getWateraccu() {
        return this.wateraccu;
    }

    public void setWalknow(long walknow) {
        this.walknow = walknow;
    }
    public long getWalknow() {
        return this.walknow;
    }

    public void setWalkday(long walkday) {
        this.walkday = walkday;
    }
    public long getWalkday() {
        return this.walkday;
    }

    public void setGood1(long good1) {
        this.good1 = good1;
    }
    public long getGood1() {
        return this.good1;
    }

    public void setGood2(long good2) {
        this.good2 = good2;
    }
    public long getGood2() {
        return this.good2;
    }

    public void setGood3(long good3) {
        this.good3 = good3;
    }
    public long getGood3() {
        return this.good3;
    }

    public void setGood4(long good4) {
        this.good4 = good4;
    }
    public long getGood4() {
        return this.good4;
    }

    public void setGood5(long good5) {
        this.good5 = good5;
    }
    public long getGood5() {
        return this.good5;
    }

    public void setGood6(long good6) {
        this.good6 = good6;
    }
    public long getGood6() {
        return this.good6;
    }

    public void setGood7(long good7) {
        this.good7 = good7;
    }
    public long getGood7() {
        return this.good7;
    }

    public void setGood8(long good8) {
        this.good8 = good8;
    }
    public long getGood8() {
        return this.good8;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }
    public long getExperience() {
        return this.experience;
    }

    public void setPet(long pet) {
        this.pet = pet;
    }
    public long getPet() {
        return this.pet;
    }

    public void setAch1(long ach1) {
        this.ach1 = ach1;
    }
    public long getAch1() {
        return this.ach1;
    }

    public void setAchievement1(long achievement1) {
        this.achievement1 = achievement1;
    }
    public long getAchievement1() {
        return this.achievement1;
    }

    public void setAch2(long ach2) {
        this.ach2 = ach2;
    }
    public long getAch2() {
        return this.ach2;
    }
}