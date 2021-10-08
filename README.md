# Lab 2 - Random Writing
 * We will write a program with several classes. Our lab programs will analyze letter frequencies in text documents and then generate new documents based on those frequencies. Each class will implement unique functionality and together they will solve a larger problem.

* Level 0 Analysis: The following algorithm is based on letter probability distributions. Imagine taking the novel Tom Sawyer and counting the frequency with which each character occurs. You’d probably find that spaces are the most common, that the character 'e' is fairly common, and that the character 'q' is rather uncommon. After completing this level 0 analysis, you’d be able to produce Tom Sawyer-esque text based on character frequencies. The idea is to randomly select each character based on the probability of it’s occurrence in the text. This random text wouldn’t have much in common with the real novel, but characters would tend to appear with the same proportions.

* Level 1 Analysis: Now imagine doing a slightly more sophisticated level 1 analysis by determining the frequency with which each character follows every other character. You would probably discover that 'h' is more likely to follow 't' than 'x', and you would probably discover that a space follows '.' more frequently than ',' does.

* Now imagine doing a level k analysis by determining the probability with which each character follows every possible sequence of characters of length k. For example, a level 5 analysis of Tom Sawyer would reveal that 'r' follows "Sawye" more frequently than any other character. After a level k analysis, you would be able to generate Tom Sawyer-esque text by always choosing the next character based on the previous k characters and the probabilities revealed by the analysis. At only a moderate level of analysis (levels 5—7), randomly-generated text begins to take on many of the characteristics of the source text. It probably won’t make complete sense, but you’ll be able to tell that it was derived from Tom Sawyer as opposed to, say, Moby Dick.
