package com.hwadee.liferay.electronic.util;


import java.io.File;

public class SealUtils {

	
    public static void OfficialSeal_2(String firLevelName,String secLevelName,String outElectronicPath) throws Exception {
    	
    	File file = new File(outElectronicPath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
    	
    	Seal seal = new Seal();
    	seal.setSize(300);
    	
    	SealCircle borderCircle = new SealCircle();
    	borderCircle.setLine(5);//粗细
    	borderCircle.setWidth(140);
    	borderCircle.setHeight(140);
    	seal.setBorderCircle(borderCircle);
    	
    	SealFont mainFont = new SealFont();
        mainFont.setText(firLevelName);
        mainFont.setSize(35);
        mainFont.setSpace(35.0);
        mainFont.setMargin(10);
        seal.setMainFont(mainFont);
        
        SealFont sealCenterFont = new SealFont();
        sealCenterFont.setText("★");
        sealCenterFont.setSize(100);
        seal.setCenterFont(sealCenterFont);
        
        SealFont sealTitleFont = new SealFont();
        sealTitleFont.setText(secLevelName);
        sealTitleFont.setSize(22);
        sealTitleFont.setSpace(10.0);
        sealTitleFont.setMargin(68);
        seal.setTitleFont(sealTitleFont); 
        
        seal.draw(outElectronicPath);
    }
    public static File drawCycleSeal(String firLevelName,String serialNumber,String secLevelName,String outElectronicPath) throws Exception {
    	
    	File file = new File(outElectronicPath);
    	if (!file.exists()) {
    		file.getParentFile().mkdirs();
    	}
    	
    	Seal seal = new Seal();
    	seal.setSize(300);
    	
    	SealCircle borderCircle = new SealCircle();
    	borderCircle.setLine(5);//粗细
    	borderCircle.setWidth(140);
    	borderCircle.setHeight(140);
    	seal.setBorderCircle(borderCircle);
    	
    	SealFont mainFont = new SealFont();
    	mainFont.setText(firLevelName);
    	mainFont.setSize(35);
    	mainFont.setSpace(35.0);
    	mainFont.setMargin(10);
    	seal.setMainFont(mainFont);
    	
    	SealFont sealCenterFont = new SealFont();
    	sealCenterFont.setText("★");
    	sealCenterFont.setSize(100);
    	seal.setCenterFont(sealCenterFont);
    	
    	SealFont sealTitleFont = new SealFont();
    	sealTitleFont.setText(secLevelName);
    	sealTitleFont.setSize(22);
    	sealTitleFont.setSpace(10.0);
    	sealTitleFont.setMargin(68);
    	seal.setTitleFont(sealTitleFont); 
    	

    	SealFont viceFont = new SealFont();
//    	viceFont.setFamily("");
    	viceFont.setText(serialNumber);
    	viceFont.setSize(10);
    	viceFont.setSpace(10.0);
    	viceFont.setMargin(3);
    	seal.setViceFont(viceFont);
    	
//    	seal.draw(outElectronicPath);
    	return seal.getDrawResFile(outElectronicPath);
    }

    public static void OfficialSeal_3(String firLevelName,String serialNumber,String secLevelName,String outElectronicPath) throws Exception {
    	File file = new File(outElectronicPath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
    	Seal seal = new Seal();
    	seal.setSize(300);
    	
    	SealCircle borderCircle = new SealCircle();
    	borderCircle.setLine(3);
    	borderCircle.setWidth(144);
    	borderCircle.setHeight(100);
    	seal.setBorderCircle(borderCircle);
    	
    	SealCircle innerCircle = new SealCircle();
    	innerCircle.setLine(1);
    	innerCircle.setWidth(140);
    	innerCircle.setHeight(96);
    	seal.setInnerCircle(innerCircle);
    	
    	SealFont mainFont = new SealFont();
        mainFont.setText(firLevelName);
        mainFont.setSize(35);
        mainFont.setSpace(12.0);
        mainFont.setMargin(10);
        seal.setMainFont(mainFont);
        
        SealFont sealCenterFont = new SealFont();
        sealCenterFont.setText(serialNumber);
        sealCenterFont.setSize(20);
        seal.setCenterFont(sealCenterFont);
        
        SealFont sealTitleFont = new SealFont();
        sealTitleFont.setText(secLevelName);
        sealTitleFont.setSize(20);
        sealTitleFont.setSpace(9.0);
        sealTitleFont.setMargin(64);
        seal.setTitleFont(sealTitleFont); 
        
        seal.draw(outElectronicPath);
    }

    public static void PrivateSeal_1(String userName,String outElectronicPath) throws Exception {
    	File file = new File(outElectronicPath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
    	Seal seal = new Seal();
    	seal.setSize(300);
    	seal.setBorderSquare(16);
    	SealFont mainFont = new SealFont();
    	mainFont.setText(userName);
    	mainFont.setSize(120);
    	seal.setMainFont(mainFont);
    	seal.draw(outElectronicPath);
    }


    public static void PrivateSeal_2(String userName,String outElectronicPath) throws Exception {
    	File file = new File(outElectronicPath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
    	Seal seal = new Seal();
    	seal.setSize(300);
    	seal.setBorderSquare(16);
    	SealFont mainFont = new SealFont();
    	mainFont.setText(userName);
    	mainFont.setSize(120);
    	seal.setMainFont(mainFont);
    	seal.draw(outElectronicPath);
    }
}
