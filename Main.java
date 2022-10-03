package com.google.lesson_10;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Human> humans = DataBase.getHumans();


//        Map<Speciality, List<Human>> map = humans
//                .stream()
//                .collect(Collectors.groupingBy(Human::getSpeciality));
//
//        map.forEach(((speciality, group) -> {
//            System.out.println(speciality);
//            group.forEach(System.out::println);
//        }));

        Map<Speciality, List<Human>> map = new HashMap<>();
        Collections.sort(humans, Comparator.comparing(Human::getSpeciality));
        List<Human> humanList = new ArrayList<>();


        for (int i = 0; i < humans.size() - 1; i++) {

            if (humans.get(i).getSpeciality() == humans.get(i + 1).getSpeciality()) {

                humanList.add(humans.get(i));


            } else {
                List<Human> temp = new ArrayList<>();
                humanList.add(humans.get(i + 1));
                for (int j = 0; j < humanList.size(); ++j) {
                    temp.add(humanList.get(j));
                }
                map.put(humans.get(i).getSpeciality(), temp);
                humanList.clear();
            }
        }

        List<Human> last = new ArrayList<>();
        last.add(humans.get(humans.size() - 1));
        map.put(humans.get(humans.size() - 1).getSpeciality(), last);
        map.forEach(((speciality, group) -> {
            System.out.println(speciality);
            group.forEach(System.out::println);
        }));

    }
}
