import java.util.Arrays;
class Question {
	String question;
	String choices;
	String answer;
	int crctmark;
	int wrngmark;
	Question(String question1, String choices1, String answer1, int crctmark1, int wrngmark1) {
		question = question1;
		choices = choices1;
		answer = answer1;
		crctmark = crctmark;
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

			System.out.println(question[i] + "(" + question[i].crctmark + ")");
			String[] displaychoice = question[i].choices.split(",");
			for (int j = 0; j < displaychoice.length; j++) {
				System.out.println(displaychoice[j] + "		");
			}
			System.out.print(displaychoice[displaychoice.length - 1]);
			System.out.println();
		}
		System.out.println();
	}
}