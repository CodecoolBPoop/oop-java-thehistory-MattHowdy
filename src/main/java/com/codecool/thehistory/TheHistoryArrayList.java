package com.codecool.thehistory;

import java.util.*;
//import java.util.Arrays;


public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information

        List<String> items = Arrays.asList(text.split("\\W+"));
        wordsArrayList.addAll(items);
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        // 65
        Iterator<String> itrArray = wordsArrayList.iterator();
        while(itrArray.hasNext()){
            if(wordToBeRemoved.equals(itrArray.next())){
                itrArray.remove();
            }
        }

        // 959 ms
//        for(int i = 0; i < wordsArrayList.size(); i++ ){
//            if(wordsArrayList.get(i).equals(wordToBeRemoved)){
//                wordsArrayList.remove(wordsArrayList.get(i));
//            }
//        }


//        2115 ms
//        while(wordsArrayList.indexOf(wordToBeRemoved) > 0){
//            wordsArrayList.remove(wordsArrayList.indexOf(wordToBeRemoved));
//        }



    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information

        //34 ms
        int len = wordsArrayList.size();

        for(int i = 0; i < len; i++){
            if(wordsArrayList.get(i).equals(from)){
                wordsArrayList.set(i, to);
            }
        }
//


        // 73 ms
//        ListIterator<String> iterator = wordsArrayList.listIterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//            if (next.equals(from)) {
//                iterator.set(to);
//            }
//        }

        // 194 ms
//        List<String> newList = new ArrayList<String>();
//        for(int i = 0; i < wordsArrayList.size(); i++)
//        {
//            if(wordsArrayList.get(i).contains(from))
//            {
//                newList.add(wordsArrayList.get(i).replace(from, to));
//                //someList.set(i, someList.get(i).replace(someString, otherString));
//            } else {
//
//                // If it not contains `someString`, add it as it is to newList
//                newList.add(wordsArrayList.get(i));
//            }
//        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        int fulLen = wordsArrayList.size();
        int fromLen = fromWords.length;
        int toLen = toWords.length;
        int fixedIndex = 0;
        boolean match = false;
        int removeFrom = 0;


        try{
            for(int i = 0; i < fulLen; i++){

                if(wordsArrayList.get(i).equals(fromWords[fixedIndex])){
                    removeFrom = i;

                    for(int j = 1; j < fromLen; j++){
                        if(wordsArrayList.get(i+1).equals(fromWords[j])){
                            match = true;

                    }

                }
                }
                if(match){
                    for (int k = removeFrom; k < fromLen; k++){
                        wordsArrayList.set(k, toWords[k]);
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException e){}
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
