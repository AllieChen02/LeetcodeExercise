package BfsAndDfs.P127WordLadder;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class WordLadderTest extends TestCase {
    public void testLadderLength() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        assertEquals(5, new WordLadder().ladderLength(beginWord, endWord, wordList));

        wordList = Arrays.asList("hot","dot","dog","lot","log");
        assertEquals(0, new WordLadder().ladderLength(beginWord, endWord, wordList));
    }
}
