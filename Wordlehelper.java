import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

class Main {

        public static ArrayList<String> wordsContainingLetter(ArrayList<String> boi,String letter){
                String temp="";
                ArrayList<String> wordbank2 = new ArrayList<String>();

                for (String word: boi){
                        if (word.contains(letter)){
                                wordbank2.add(word);
                                temp=temp+" "+word;
                        }
                }
                return wordbank2;
        }

        public static ArrayList<String> wordsNotContainingLetter(ArrayList<String> boi,String letter){
                String temp="";
                ArrayList<String> wordbank2 = new ArrayList<String>();

                for (String word: boi){
                        if (word.contains(letter)==false){
                                wordbank2.add(word);
                                temp=temp+" "+word;
                        }
                }
                return wordbank2;
        }

        public static ArrayList<String> wordsContainingLetterAtIndex(ArrayList<String> boi,String letter, int index){
                String temp="";
                ArrayList<String> wordbank2 = new ArrayList<String>();

                for (String word: boi){
                        if (Character.toString(word.charAt(index)).equals(letter)){
                                wordbank2.add(word);
                                temp=temp+" "+word;
                        }
                }
                return wordbank2;
        }

        public static ArrayList<String> wordsNotContainingLetterAtIndex(ArrayList<String> boi,String letter, int index){
                String temp="";
                ArrayList<String> wordbank2 = new ArrayList<String>();

                for (String word: boi){
                        if (Character.toString(word.charAt(index)).equals(letter)==false){
                                wordbank2.add(word);
                                temp=temp+" "+word;
                        }
                }
                return wordbank2;
        }

        public static ArrayList<String> frequencyOfLettersInAllWords(ArrayList<String> boi){
                char c;
                int count=0;
                String temp="";
                ArrayList<String> wordbank2 = new ArrayList<String>();

                ArrayList<String> duplicates = new ArrayList<String>();

                for(c = 'a'; c <= 'z'; ++c) {
                        for (String word : boi) {
                                ArrayList<String> duplicates2 = new ArrayList<String>();

                                if (word.contains(Character.toString(c))&&duplicates2.contains(c)==false) {
                                        count = count + 1;
                                        duplicates2.add(Character.toString(c));
                                }
                                if (boi.indexOf(word) == boi.size() - 1) {
                                        temp=c + " count is-" + count;
                                        wordbank2.add(temp);
                                        count = 0;
                                }
                        }
                }
                return wordbank2;
        }

        public static ArrayList<String> frequencyOfLettersInAtIndex(ArrayList<String> boi, int index){
                char c;
                int count=0;
                String temp="";
                ArrayList<String> wordbank2 = new ArrayList<String>();

                for(c = 'a'; c <= 'z'; ++c) {
                        for (String word : boi) {
                                if (Character.toString(word.charAt(index)).equals(Character.toString(c))==true) {
                                        count = count + 1;
                                }
                                if (boi.indexOf(word) == boi.size() - 1) {
                                        temp=c + " count is-" + count;
                                        wordbank2.add(temp);
                                        count = 0;
                                }
                        }
                }
                return wordbank2;
        }



        public static  HashMap<String, Integer> sort(ArrayList<String> boi){
                char c;
                int index=0;
                HashMap<String, Integer> Scores = new HashMap<String, Integer>();
                ArrayList<String> sortedList= new ArrayList<String>();
                ArrayList<Integer> intScores = new ArrayList<Integer>();
                for (String scores : boi){
                        intScores.add(Integer.valueOf(scores.substring(11)));
                }
                Collections.sort(intScores, Collections.reverseOrder());
                while (index<25) {
                        for (String scores : boi) {
                                if (Integer.valueOf(scores.substring(11)).equals(intScores.get(index))) {
                                        sortedList.add(scores);
                                        index++;
                                }
                        }
                }
                for (String scores : sortedList){
                }

                        int scored=26;
                for (String scores : sortedList){
                        Scores.put(Character.toString(scores.charAt(0)),scored);
                        scored--;
                }
                Scores.put("q",1);
                for (String name: Scores.keySet()) {
                        String key = name.toString();
                        String value = Scores.get(name).toString();
                }
                return Scores;
        }

        public static  HashMap<String, Integer> score(HashMap<String, Integer> boi, String word){
                int score=0;
                HashMap<String, Integer> wordScores = new HashMap<String, Integer>();
                String[] wordList=word.split("");
                for (String letter: wordList ){
                        score=score+boi.get(letter);
                }
                wordScores.put(word,score);

                return wordScores;
        }


        public static  HashMap<String, Integer> rankWordBank(HashMap<String, Integer> boi, ArrayList<String> wordBank){
                int score=0;
                HashMap<String, Integer> wordScores = new HashMap<String, Integer>();

                for (String word: wordBank) {
                        String[] wordList = word.split("");
                        ArrayList<String> duplicates = new ArrayList<String>();
                        for (String letter : wordList) {
                                if (duplicates.contains(letter)==false) {
                                        score = score + boi.get(letter);
                                        duplicates.add(letter);
                                }
                        }
                        wordScores.put(word, score);
                        score=0;
                }
                return wordScores;
        }

                public static void main(String[] args) {
                ArrayList<String> wordbank = new ArrayList<String>();
                        try (BufferedReader br = new BufferedReader(new FileReader("wordbank.txt"))){

                        String sCurrentLine;

                        while ((sCurrentLine = br.readLine()) != null) {
                                wordbank.add(sCurrentLine);
                        }
                        } catch (IOException e) {
                        e.printStackTrace();

                }
                        ArrayList<String> wordbank2 = wordbank;


                        Scanner scanner = new Scanner(System.in);

                ArrayList<String> firstScores = frequencyOfLettersInAllWords(wordbank);


                HashMap<String, Integer> getitoverwith = sort(firstScores);
                int boi=0;
                while (boi==0){
                        HashMap<String, Integer> boiyes = rankWordBank(getitoverwith,wordbank);

                        for (String name: boiyes.keySet()) {
                                String key = name.toString();
                                String value = boiyes.get(name).toString();
                                System.out.println(key + " " + value);
                        }

                        Map.Entry<String, Integer> maxEntry = null;

                        for (Map.Entry<String, Integer> entry : boiyes.entrySet())
                        {
                                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                                {
                                        maxEntry = entry;
                                }
                        }
                        System.out.println("This is your highest scoring word: "+maxEntry);

                        System.out.println("Would you like to reset your wordbank? Please enter yes if you want to or no to skip. ");
                        String resetResponse = scanner.next();
                        if (resetResponse.equals("yes")){
                                wordbank=wordbank2;
                        }
                        System.out.println("Were there any gray letters? ");
                        String greyLetterResponse = scanner.next();
                        if (greyLetterResponse.equals("yes")){
                                System.out.println("Please enter the letters that are gray in a single lowercase line");
                                String greyLetters = scanner.next();
                                String[] greyList=greyLetters.split("");
                                for (String letter : greyList){
                                        wordbank=wordsNotContainingLetter(wordbank,letter);
                                }
                        }
                        System.out.println("Were there any green letters?");
                        String greenLetterResponse = scanner.next();
                        if (greenLetterResponse.equals("yes")){
                                int index = 0;
                                System.out.println("Please enter the letters that are green in a single lowercase line in order that they appear");
                                String greenLetters = scanner.next();
                                System.out.println("Please enter the index of the letters in the order that they appear");
                                String greenIndex =  scanner.next();
                                String[] greenList=greenLetters.split("");
                                for (String letter: greenList){
                                        wordbank=wordsContainingLetterAtIndex(wordbank,letter,Character.getNumericValue(greenIndex.charAt(index)));
                                        index++;
                                }
                        }
                        System.out.println("Were there any yellow letters?");
                        String yellowLetterResponse = scanner.next();
                        if (yellowLetterResponse.equals("yes")) {
                                int index = 0;
                                System.out.println("Please enter the letters that are yellow in a single lowercase line in order that they appear");
                                String yellowLetters = scanner.next();
                                System.out.println("Please enter the index of the letters in the order that they appear");
                                String yellowIndex =  scanner.next();
                                String[] yellowList=yellowLetters.split("");
                                for (String letter : yellowList){
                                        wordbank=wordsContainingLetter(wordbank,letter);
                                }
                                for (String letter: yellowList){
                                        wordbank=wordsNotContainingLetterAtIndex(wordbank,letter,Character.getNumericValue(yellowIndex.charAt(index)));
                                        index++;
                                }

                        }

                }

        }
}
