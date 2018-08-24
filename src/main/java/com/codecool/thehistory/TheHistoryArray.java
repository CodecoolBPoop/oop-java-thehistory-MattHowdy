package com.codecool.thehistory;

import com.sun.tools.javac.util.ArrayUtils;

import java.lang.reflect.Array;
import java.util.Arrays;


public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] textArray = text.split("\\W+");
        int fullLength = wordsArray.length + textArray.length;

        String[] tempArray = new String[fullLength];
//        start
        System.arraycopy(wordsArray, 0, tempArray, 0, wordsArray.length);
//          end
        System.arraycopy(textArray, 0, tempArray, wordsArray.length, textArray.length);


        wordsArray = tempArray;
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        int len = wordsArray.length;

        String[] tempArray = new String[len];
        int j = 0;

        for(int i =0; i < len; i++){
            if(!wordToBeRemoved.equals(wordsArray[i])){
                tempArray[j] = wordsArray[i];
                j += 1;
            }
        }

        wordsArray = new String[j];
        System.arraycopy(tempArray, 0,wordsArray,0, j);

    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        int len = wordsArray.length;

        for(int i = 0; i < len; i++){
            if(wordsArray[i].equals(from)){
                wordsArray[i] = to;
            }
        }

    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        int fullLen = wordsArray.length;
        int fromLen = fromWords.length;
        int toLen = toWords.length;

        int tempArrayLen = fullLen;
        boolean itsMatch = false;

        //for arraycopy
        int firstEnd = 0;

        String[] tempArray = new String[tempArrayLen];
        try{
            for(int i = 0; i < (fullLen*2); i++){
                firstEnd = i;
                int tempIndexforWords = 0;

                if(wordsArray[i].equals(fromWords[tempIndexforWords])){

                    for(int j = 1; j < fromLen; j++){
                    firstEnd = i;
                    if(wordsArray[i+1].equals(fromWords[j])){
                        tempArrayLen += toLen;
                        tempArrayLen -= fromLen;
                        itsMatch = true;
                    }
                    else{
                        itsMatch = false;
                    }
                }
            }

//                    tempIndexforWords ++;
                }
                if(itsMatch ){
                    // start
                    System.arraycopy(wordsArray, 0, tempArray, 0, firstEnd);
                    // toWords
                    System.arraycopy(toWords,0, tempArray, firstEnd, toLen );
                    // end
                    System.arraycopy(wordsArray, firstEnd+fromLen, tempArray,firstEnd+toLen, fullLen-firstEnd-fromLen );

                    //copy to wordsArray
                    wordsArray = new String[fullLen-fromLen+toLen];
                    System.arraycopy(tempArray, 0,wordsArray,0, tempArrayLen);
                    itsMatch = false;
                }


        }
        catch(ArrayIndexOutOfBoundsException|NullPointerException e){};
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
