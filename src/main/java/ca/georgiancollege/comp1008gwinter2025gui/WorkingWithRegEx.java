package ca.georgiancollege.comp1008gwinter2025gui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkingWithRegEx {
/*
    regex
        regular expression
            advanced searching

    Special Characters

    Position
    ^
    $

        ^a
        ^A

        s$
        S$

    Grouping
    []
    [abc]
    [123]
    [m-z]
    [5-8]
    [^abc]

    ()

    a|b

    Quiz:
            RegEx       love|hate
            Text       I love java. I hate people who think java is not cool

            RegEx       [a-e]
            Text       I love java. 0

            RegEx       [^a-e]
            Text       I love java.

            RegEx       (b|c)at
            Text        The cat in the hat ate the bat


    Repetition
    {N}     exact N times
    {N,}    at least N times
    {N,M}   between N and M times

    +       one or many times
    *       zero or many times
    ?       zero or one time aka optionally

    Character Matching
    .       Match any character


    Quiz
        Regex   .{2,}t
        Text:   The cat at Georgian, in the hat was holding a bat to strike the rat, who is wearing a beret

    Shortcuts
    \d          digits          [0-9]
    \D          non-digits      [^0-9]
    \w          word            [a-zA-Z0-9_]
    \W          non-word        [^a-zA-Z0-9_]
    \s          whitespace      [\t\n\t\r ]
    \S          non whitespace  [^\t\n\t\r ]




\(?\d{3}\)?[-\s]\d{3}[-\s]\d{4}|\d{10}


 */

    public static void main(String[] args) {


        String pattern = "\\d+";
        String justNumber = "7055551234";
        String text = "My number is 705-555-1234";

        boolean matches = Pattern.matches(pattern, justNumber);
        System.out.println(matches);


    }
}
