import java.util.Arrays;
class Question {
	String questionname;
	String choices;
	String answer;
	int crctmark;
	int wrngmark;
	Question(String question1, String choices1, String answer1, int crctmark1, int wrngmark1) {
		questionname = question1;
		choices = choices1;
		answer = answer1;
		crctmark = crctmark1;
		wrngmark = wrngmark1;
	}
}
class Quiz {
	public Question[] question = new Question[4];
	int quescount;
	String[] userchoice = new String[4];
	int userchoicecount;
	int totalscore;
	Quiz() {
		quescount = 0;
		userchoicecount = 0;
		totalscore = 0;
	}

	void quesresize() {
		question = Arrays.copyOf(question, 2 * quescount);
	}

	void choiceresize() {
		userchoice = Arrays.copyOf(userchoice, 2 * userchoicecount);		
	}

	void displaycount() {
		System.out.println(quescount + " are added to the quiz");
	}

	void addtoques(Question ques) {
		if (quescount == question.length) {
			quesresize();
		}

		question[quescount] = ques;
		quescount++;
	}

	void addtochoices(String userchoices) {
		if (userchoicecount == userchoice.length) {
			choiceresize();
		}

		userchoice[userchoicecount++] = userchoices;
	}

	void displayqueschoice() {
		for (int i = 0; i < quescount; i++) {
			if (i > 0) {
				System.out.println();
			}

			System.out.println(question[i].questionname + "(" + question[i].crctmark + ")");
			String[] displaychoice = question[i].choices.split(",");
			for (int j = 0; j < displaychoice.length - 1; j++) {
				System.out.print(displaychoice[j] + "	");
			}
			System.out.print(displaychoice[displaychoice.length - 1]);
			System.out.println();
		}
		System.out.println();
	}

	int caluculatescore() {
		for (int i = 0; i < quescount; i++) {
			if (userchoice[i].split(" ")[1].equals("a") || userchoice[i].split(" ")[1].equals("b") || userchoice[i].split(" ")[1].equals("c") || userchoice[i].split(" ")[1].equals("d")) {
				if(question[i].answer.equals("1")) {
					question[i].answer = "a";
				} else if (question[i].answer.equals("2")) {
					question[i].answer = "b";
				} else if (question[i].answer.equals("3")) {
					question[i].answer = "c";
				} else {
					question[i].answer = "d";
				}
			}

			if (userchoice[i].split(" ")[1].equals("1") || userchoice[i].split(" ")[1].equals("2") || userchoice[i].split(" ")[1].equals("3") || userchoice[i].split(" ")[1].equals("4")) {
				if (question[i].answer.equals("1")) {
					question[i].answer = question[i].choices.split(",")[0].split(" ")[1];
				} else if (question[i].answer.equals("2")) {
					question[i].answer = question[i].choices.split(",")[1].split(" ")[1];
				} else if (question[i].answer.equals("3")) {
					question[i].answer = question[i].choices.split(",")[2].split(" ")[1];
				} else {
					question[i].answer = question[i].choices.split(",")[3].split(" ")[1];
				}
			}

			System.out.println(question[i].questionname);
			if (question[i].answer.equals(userchoice[i].split(" ")[1])) {
				System.out.println(" Correct Answer! - Marks Awarded: " + question[i].crctmark);
				totalscore = totalscore + question[i].crctmark;
			} else {
			    System.out.println(" Wrong Answer! - Penalty: " + question[i].wrngmark);
			    totalscore = totalscore + question[i].wrngmark;
			}
		}
		return totalscore;
	}
}