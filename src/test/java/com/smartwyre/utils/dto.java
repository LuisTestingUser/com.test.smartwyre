package com.smartwyre.utils;

import java.util.Random;

public class dto {

    public static class ProductRequest {
        private String name;
        private ProductData data;

        public ProductData getData() {
            return data;
        }

        public void setData(ProductData data) {
            this.data = data;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public ProductRequest() {
            this.name = generateRandomName();
        }
        private String generateRandomName() {
            String[] deviceBrandName = {"Samsung", "iPhone", "Xioami", "LG", "OnePlus","Motoral","Huawei","Google"};
            String[] deviceModelName = {"10", "10S", "10S PRO", "11X", "258","987.5" };

            Random random = new Random();
            int deviceIndex = random.nextInt(deviceBrandName.length);
            int modelIndex = random.nextInt(deviceModelName.length);
            return deviceBrandName[deviceIndex] + " " + deviceModelName[modelIndex];
        }


    }

    public static class ProductData {
        private int year;
        private double price;
        private String cpuModel;
        private String hardDiskSize;

        public ProductData(int year, double price, String cpuModel, String hardDiskSize) {
            this.year = year;
            this.price = price;
            this.cpuModel = cpuModel;
            this.hardDiskSize = hardDiskSize;
        }


        public ProductData() {
            Random random = new Random();
            this.year = random.nextInt(25) + 2000;

            this.price = random.nextDouble() * 9000 + 1000;

            String[] cpuModels = {"Intel Core i9", "AMD Ryzen 9", "Apple M1", "Qualcomm Snapdragon 8 Gen 2"};
            this.cpuModel = cpuModels[random.nextInt(cpuModels.length)];

            String[] hardDiskSizes = {"1 TB", "2 TB", "512 GB", "128 GB"};
            this.hardDiskSize = hardDiskSizes[random.nextInt(hardDiskSizes.length)];
        }


        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getCpuModel() {
            return cpuModel;
        }

        public void setCpuModel(String cpuModel) {
            this.cpuModel = cpuModel;
        }

        public String getHardDiskSize() {
            return hardDiskSize;
        }

        public void setHardDiskSize(String hardDiskSize) {
            this.hardDiskSize = hardDiskSize;
        }



    }
    public class ProductResponse {
        private String id;
        private String name;
        private ProductData data;
        private String createdAt;


        public ProductData getData() {
            return data;
        }

        public void setData(ProductData data) {
            this.data = data;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }



    }


}
