import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;



public class TaskManager
{
	static ArrayList<Task> tasks = new ArrayList<>();
	static ArrayList<Task> completeTask = new ArrayList<>();



	// ADDTASK
	public static void addTask(String title, String description, boolean status) {

		Task task = new Task();
		task.setTittle(title);
		task.setDescription(description);
		task.setDate(LocalDate.now());
		task.setStatus(status);

		tasks.add(task);

		System.out.println(" ");
		System.out.println(" Task added");
		System.out.println(" Task: " + task.getTitle());
		System.out.println(" Description: " + task.getDesciption());
		if(task.getStatus() == false) {
			System.out.println(" Status: Not Completed");
		}

		System.out.println(" Date created: " + task.getDate());
		System.out.println(" ");
	}

	// VIEWTASK
	public static void viewTask() {

		if(tasks.isEmpty()) {

			System.out.println(" ");
			System.out.println(" No added tasks yet");
			return;

		}

        System.out.println(" ");
		System.out.println(" ALL TASKS");
        System.out.println(" ");

		for(int i = 0; i < tasks.size(); i++) {

			Task task = tasks.get(i);

			if(task.getStatus() == false) {

				System.out.println(" Task: " + task.getTitle());
				System.out.println(" Description: " + task.getDesciption());
				System.out.println(" Status: Not Completed");
				System.out.println(" Date created: " + task.getDate());
				System.out.println(" ");

			}

			if(task.getStatus() == true) {

				System.out.println(" Task: " + task.getTitle());
				System.out.println(" Description: " + task.getDesciption());
				System.out.println(" Status: Completed");
				System.out.println(" Date Completed: " + task.getDate());
				System.out.println(" ");

			}

		}

	}



	// DELETE TASK
	public static void deleteTask(String taskToDelete) {

		if(tasks.isEmpty()) {
			System.out.println(" No current tasks");
			return;
		}

		viewTask();

		boolean found = false;

		for(int i = 0; i < tasks.size(); i++) {

			Task tempDelete = tasks.get(i);

			if(taskToDelete.equalsIgnoreCase(tempDelete.getTitle())) {

				System.out.println(" ");
				System.out.println(" Task: " + tempDelete.getTitle() + " has been deleted");

				tasks.remove(i);

				found = true;
				break;

			}
		}


		if(!found) {

			System.out.println(" No task name found");

		}
	}


	// EDITTASK
	public static void editTask(String taskToEdit, String newTitle, String newDescription ) {


		for(Task tempEdit : tasks) {
			if(taskToEdit.equalsIgnoreCase(tempEdit.getTitle())) {

				tempEdit.setTittle(newTitle);
				tempEdit.setDescription(newDescription);
				tempEdit.setDate(LocalDate.now());
                tempEdit.setStatus(false);

				System.out.println(" ");
				System.out.println(" Task: " + tempEdit.getTitle() + " has been updated");
				System.out.println(" New Description: " + tempEdit.getDesciption());
				System.out.println(" Task updated Date: " + tempEdit.getDate());

			}
		}
	}


	// COMPLETE TASK
	public static void completeTask( String taskToComplete) {

		if(tasks.isEmpty()) {
			System.out.println(" No Current tasks");
		} else {

			viewTask();

		}

		boolean Complete = false;

		for(Task tempTask : tasks) {

			if(tempTask.getTitle().equalsIgnoreCase(taskToComplete)) {

				Complete = true;
				tempTask.setStatus(Complete);

				System.out.println(" Task: " + tempTask.getTitle());
				System.out.println(" Description: " + tempTask.getDesciption());

				if(tempTask.getStatus() == true) {

					tempTask.setDate(LocalDate.now());
					System.out.println(" Status: Completed");

				}

				System.out.println(" Date Completed: " + tempTask.getDate());

				completeTask.add(tempTask);
				break;

			}

		}
        
		if(!Complete) {

			System.out.println(" No match task ");

		}
	}


	// SEARCH TASK
	public static void searchTask( String searchName) {

		boolean searchOut = false;
		for(Task tempSearch: tasks) {

			if(tempSearch.getTitle().equalsIgnoreCase(searchName)) {

				if(tempSearch.getStatus() == false) {

                    System.out.println("  ");
					System.out.println(" Task: " + tempSearch.getTitle());
					System.out.println(" Description: " + tempSearch.getDesciption());
					System.out.println(" Status: Not Completed");
					System.out.println(" Date created: " + tempSearch.getDate());
					System.out.println(" ");
				}

				if(tempSearch.getStatus() == true) {

					System.out.println(" Task: " + tempSearch.getTitle());
					System.out.println(" Description: " + tempSearch.getDesciption());
					System.out.println(" Status: Completed");
					System.out.println(" Date created: " + tempSearch.getDate());
					System.out.println(" ");

				}

				searchOut = true;
				break;
			}

		}
		if(!searchOut) {

			System.out.println(" Not found ");

		}
	}








	// MAIN MAIN
	public static void main(String []args) {

		Scanner scan = new Scanner(System.in);


		System.out.println(" Welcome this program help you manage your task");
		String exit = " ";


		do {

			String menu = " ";

			while(!menu.equalsIgnoreCase("Add")&& !menu.equalsIgnoreCase("Complete")&&!menu.equalsIgnoreCase("Delete")&&
			        !menu.equalsIgnoreCase("Edit")&&!menu.equalsIgnoreCase("Exit") &&!menu.equalsIgnoreCase("View")&&!menu.equalsIgnoreCase("search")) {


				System.out.println(" ");
				System.out.println(" Task Manager");
				System.out.println(" ");
				System.out.println(" Menu (Choose valid options):");
				System.out.println(" ");
				System.out.println(" Add - To create task  ");
				System.out.println(" View - Show all tasks");
				System.out.println(" Complete - Mark task as done ");
				System.out.println(" Delete - Remove a task ");
				System.out.println(" Edit - Modify task details");
				System.out.println(" Search - Search Task");
				System.out.println(" Exit - Exit the program");
				System.out.print(" : ");
				menu = scan.nextLine();
				System.out.println(" ");


			}

			if(menu.equalsIgnoreCase("ADD")) {

				String title, description;
				String out = " ";

				do {
					while(true) {


						System.out.println(" ");
						System.out.print(" Title of your task: ");

						title = scan.nextLine();

						System.out.print(" Descriptions: ");

						description = scan.nextLine();

						if(!title.isBlank() || !description.isBlank()) {

							addTask(title,description,false);
							break;

						}

						System.out.println(" Title or Description is blank");

					}

					out = " "; // change value

					while(!out.equalsIgnoreCase("Yes") && !out.equalsIgnoreCase("No")) {

						System.out.print(" ");
						System.out.println(" Add another? (Yes | No)");
						System.out.print(" : ");
						out = scan.nextLine();

					}

				} while(!out.equalsIgnoreCase("no"));

			}// IF ADD


			// DELETE
			if(menu.equalsIgnoreCase("DELETE")) {

				String delete = " ";
				String out = " ";

				do {


					out = " ";
					delete = " ";

					if(!tasks.isEmpty()) {


						System.out.println(" Type the name of the task you want to delete ");
						System.out.print(" : ");
						delete = scan.nextLine();
						deleteTask(delete);
						System.out.println(" ");

						while(!out.equalsIgnoreCase("Yes") && !out.equalsIgnoreCase("No")) {

							System.out.print(" ");
							System.out.println(" Delete another? (Yes | No)");
							System.out.print(" : ");
							out = scan.nextLine();

						}

					}else {

						System.out.println(" ");
						System.out.println(" - No current task ");
						break;

					}

				} while(!out.equalsIgnoreCase("no"));

			}// IF DELETE


			// VIEWTASK
			String viewOut = " ";
			if(menu.equalsIgnoreCase("View")) {

				while(!viewOut.equalsIgnoreCase("yes")) {

					viewTask();
					System.out.print(" Back (Yes): ");
					viewOut = scan.nextLine();

				}
			} // IF view

			// EditTask
			if(menu.equalsIgnoreCase("Edit")) {

				String done = " ";

				if(!tasks.isEmpty()) {


					do {


						String newName, newDescription, nameEdit;

						System.out.println(" Enter the name of the task you want to edit ");
						System.out.print(" : ");
						nameEdit = scan.nextLine();
						done = " ";

						for( Task tempEdit : tasks) {

							if(tempEdit.getTitle().equalsIgnoreCase(nameEdit)) {

								System.out.println(" Enter new name for the task");
								System.out.print(" : ");
								newName = scan.nextLine();

								System.out.print(" Enter new description for the task");
								System.out.print(" : ");
								newDescription = scan.nextLine();

								editTask(nameEdit,newName,newDescription);
								break;

							} else {
                                System.out.println(" ");
								System.out.println(" No task found ");

							}
						}//for



						do {



							System.out.println(" Edit another? (Yes | No)");
							done = scan.nextLine();

						} while (!done.equalsIgnoreCase("Yes") &&!done.equalsIgnoreCase("No"));



					} while(!done.equalsIgnoreCase("no"));

				} else {
					System.out.println(" - There is no current task to edit ");
				}

			} // IF Edit


			// CompleteTask
			if(menu.equalsIgnoreCase("Complete")) {
				String completeOut =" ";
				String toBeCompleted = " ";
				if(!tasks.isEmpty()) {


					do {

						completeOut = " ";
						System.out.println("Enter the name of the task you want to mark as complete ");
						System.out.print(" : ");
						toBeCompleted = scan.nextLine();
						completeTask(toBeCompleted);

						do {

							System.out.println(" Mark another task as complete? (Yes | No)");
							completeOut = scan.nextLine();

						} while(!completeOut.equalsIgnoreCase("Yes") &&!completeOut.equalsIgnoreCase("No"));

					} while(!completeOut.equalsIgnoreCase("No"));

				} else {

                    System.out.println(" ");
					System.out.println(" No current task to be completed");

				}


			}// if complete


			// Search
			String searchOut = " ";
			if(menu.equalsIgnoreCase("search")) {


				String searchName = " ";

				do {
					searchOut = " ";
					if(!tasks.isEmpty()) {

						System.out.println(" Enter the name of the task you want to search");
						System.out.print(" : ");
						searchName = scan.nextLine();
						searchTask(searchName);

					} else {
                        System.out.println(" ");
						System.out.println(" - No added task to search");
						break;
					}



					while(!searchOut.equalsIgnoreCase("yes") && !searchOut.equalsIgnoreCase("no")) {
						System.out.println(" Search again?(Yes | No)");
						searchOut = scan.nextLine();
					}



				} while(!searchOut.equalsIgnoreCase("no"));



			}


			// Exit
			if(menu.equalsIgnoreCase("Exit")) {
				System.out.println(" ");
				System.out.println(" Exiting Task Manager... ");
				return;
			} // if exit

		} while(!exit.equalsIgnoreCase("exit")); // End

        
	} // main
} // class
