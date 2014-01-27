**Code Challenge: Gibberish Generator**
---------------------------------------

Challenge Overview

------------------

**Your response to this challenge can be used to supplement your SWEAP application.  If you plan to complete this challenge for SWEAP, ensure you meet the other minimum requirements by visiting [here](http://gecapital.com/sweap "SWEAP Home Page").  Whether you apply or not, you are welcome to fork this repository and complete as a personal project challenge.**


We are exticed taht you are intsereted in joiinng the Soawtfre Engreeniing Appsecitnerhip Prargom.  Weoclme to yuor fsrit prommarging chanellge.  Yuor chnellage is to courtsnct a prrgoam taht tekas an Enilgsh txet snirtg as iupnt and rerutns rebadale giirebbsh lkie tihs.  It dseno’t mtaetr in waht oerdr the ltteres in a wrod are, but an iproamtnt tihng is taht the frsit and lsat ltteer be in the rghit pclae. The rset can be a taotl mses and you can sitll raed it whotuit a pboerlm.  Tihs is bcuseae the huamn mnid deos not raed ervey lteter by istlef, but the wrod as a wlohe.

**The Basics:**
  
  - You may use *almost any* programming language... it's your choice.  See the supported options [here](http://ideone.com/).
  - Your program should leave the first and last letter of each word in place and scramble the rest.
  - Your program should not scamble punctuation (.,-'...etc.), numbers, or upper-case abbreviations.
  - For example gibberish, see the [/textfiles](https://gitlab.cs.uno.edu/sweap/gibgen/tree/master/textfiles) folder.  Two sample output files are provided: `xxx.txt.gib`

**Input/Output:**
 
  - Name your program as follows: `gibgen.xx` (where xx is variable based on the language you choose)
  - Your program should be able to read text input from a string passed into STDIN
      - `gibgen.xx "This is a String"`
      - `cat mystringfile.txt | gibgen.xx`
  - Your program should output to the console.

_Note: This challenge is based on a popular word gibberish meme. You can improve the readability by looking at a [researcher's take](http://www.mrc-cbu.cam.ac.uk/people/matt.davis/cmabridge/) on the truths/myths of this meme, but this is not required._

What to do
----------
1. [Download](http://git-scm.com/downloads) & install Git on your machine

2. <a href="https://gitlab.cs.uno.edu/sweap/gibgen/fork" class="btn grouped" data-method="POST" rel="nofollow" title="Fork">Fork</a> this project - Go [here](https://gitlab.cs.uno.edu/sweap/gibgen) and click the "Fork" button (located on the upper-right side of the screen)

2. Clone your new fork'd repository to your local machine - `git clone https://gitlab.cs.uno.edu/YOUR_USERNAME_HERE/gibgen.git`
3. Complete the code challenge and fill out the Quick Start & Questions in the the README (see below)
4. `git add` and `git commit` your local repository as you go
4. Push your code and README back to UNO's GitLab occasionally - `git push origin master`
5. Email [serp@ge.com](mailto:serp@ge.com) with the Commit URL to your fork'd repository that you want reviewed. It should include at least 2 files: (1) your updated README with Coding Questions answered, and (2) your program (gibgen.xx)
   - Grant the "SWEAP" user "MASTER"-level access to your repository by going here `https://gitlab.cs.uno.edu/YOUR_USERNAME_HERE/gibgen/team` and clicking the "New Team Member" button.
   - Then go here: `https://gitlab.cs.uno.edu/YOUR_USERNAME_HERE/gibgen/commits/master`
   - Find the commit that you'd like us to review.  _The commit date must be on or before 11:59pm (central) on Nov-10!_
       - Click the "Browse Code ->" link for that commit
   - Copy and paste the URL into the email along with your name... it should look something like this:
       - `https://gitlab.cs.uno.edu/YOUR_USERNAME_HERE/gibgen/tree/73afe0c8fe2...hash.hash...e80afea72b6`

_Note: If you have any questions, email [serp@ge.com](mailto:serp@ge.com).  I will do my best to respond to any questions Saturday & Sunday evening._

Judging Criteria
----------------

Your responses to the **Coding Questions** at the bottom of this README are the *Most Important* part of this challenge. A working, fully fault-tolerant program that we just can't break, albeit awesome, is the least important.  Why is that?  Remember, we don't expect you to be expert programmers (just yet)... We want to see how you think through a problem.  


For completion by applicant
===========================

Quick Start
-----------

Instructions on how to execute the program
1.	Get a String input from the command line
	a.	Concatenate if there are multiple lines.
2.	Send the String to scramble() method
3.	In scramble() method, the first character of the given string is analyzed so the string can be processed with the correct method.
4.	In either of the two methods letterFirst() or letterLast(), a scanner with custom delimiters parses the given string. Each individual token composed of letters only are analyzed by analyze() method, whether if said token should be sent to wordScramble() method where the “real” scrambling happens”
5.	If the token is sent to wordScramble(), wordScramble() returns the scrambled version of the token and the token is appended into a StringBuilder.
6.	Once the method, either letterFirst() or letterLast(), is complete, it returns the scrambled version of the given string to scramble().
7.	Scramble() then sends the scrambled version back to the main() method to be printed out with System.out.


* What programming language did you use? Java


* Also tell us anything else the reviewer should know about your code: 

I would like to note that I think the command line example 'gibgen.java "This is a string"' behaves differently on Windows.
I had to enter 'java gibgen' and hit 'Enter', then there's a new line with prompt in it. Enter a desired string then hit 'Enter' again will pass the string to the class. It takes at least two lines compared to example's single command line.
I hope this is the same behavior as 'gibgen.java "This is a string"'

Additionally for reading cat from a file, the windows version of cat is 'type filename.txt | java gibgen'



Coding Questions
----------------

Question 1: "How did you approach the problem?" (500 words or less)

I read the problem over and wrote down quick notes on what I need to do. After I finished reading the problem, I looked at my quick notes and realized an informal structure of static methods I need to do. Now at this point, it was a good idea for me to write down the methods and what each method did. If I find one method to be complex, I broke it down into simpler methods such as auxiliary methods. Next, on the class itself, I wrote stubbed methods and filled out the comments as well as contracts. I decided not to use the DrJava JUnit test cases because I’ve felt this was simple enough to test the code by hand.

Next, I did some research on the Scanner class and the StringBuilder class. I’ve discovered how to use delimiters, or rather re-learned how to use delimiters. I just knew that using the delimiters of the Scanner class is probably the easiest option I could take to solve the problem of parsing the words and punctuations properly.

When I noticed I saw that the StringBuilder class had a method called deleteCharAt(), I immediately thought of the random number generate and how it could provide me index values of a string. Naturally, that led to solving the problem of scrambling the words.

Overall, it wasn’t too difficult to solve the problem itself. If I must say, it took me around 5 hours to finally complete the scramble method.  I never hit any proverbial walls that stumped me, at least not for a long time. When I got stumped such as when trying to figure out how to parse the string correctly, I expanded my mind and I remembered using delimiters from when I was in high school. That memory alone led me to solve the problem of parsing the string.



Question 2: "What was the most difficult aspect of the solution?" (500 words or less)

The most difficult aspect of the solution was actually not part of the solution itself. I was never taught how to take an input via Standard Input from the command prompt (cmd) at UNO so far. I had to use Google on Mr. Serpas’ advice about enabling the program to take in the Standard Input. Next, I had to learn how to use the command prompt (cmd). Serpas’ cmd line examples were not Windows based so I had to find the Windows version of cat and accessing a java file. That was the only hard part, I believe, about the coding challenge. Writing the BufferedReader itself wasn’t difficult, other than realizing that I had to somehow read multiple lines of input. I had to do research and discovered the ready() method which made BufferedReader much easier to use than a Scanner as STDIN, but I digress.

Overall, the difficulty of the code challenge could have been much greater if I didn’t do research. I took advantage of the existing classes and methods that weren’t taught in classes to water down the difficulty of the solution, and greatly broke down the complex methods into simpler methods. This code challenge was a great learning experience for me. I am excited to have learned how to break away from Java console by using the command prompt to input things into java classes.
