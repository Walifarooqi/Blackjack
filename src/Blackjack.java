import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {

        P1Random generateCards = new P1Random(); //P1 random class to generate random numbers during the gamme

        Scanner scnr = new Scanner(System.in);

        boolean letsPlay = true;
        int playerCard; // declared to generate cards for the player
        int dealersHand; // declared to establish the value of the dealers hand. Will be incremented regularly.

        int gamesPlayed; //declared to keep track of games played. Will be incremented after each iteration of the fame
        gamesPlayed = 1;

        int playerWins = 0; //declared to track and increment the number of times the player wins
        int dealerWins = 0; //declared to track and increment the number of times the dealer wins
        int gameTied = 0; //declared to track and increment the number of times the game is tied

        int menuSelect; //

        while (letsPlay) { //Main loop that keeps game running till exited by the player

            System.out.println("START GAME #" + gamesPlayed + "\n");
            gamesPlayed++; //So that there is a new game# each time the game loops


            int playersHand = 0; // declared to establish the value of the Players hand. Will be incremented regularly

            playerCard = generateCards.nextInt(13) + 1; //Generates the players cards and gives them random numbers

            if (playerCard == 13) {
                System.out.println("Your card is a KING!");
                playersHand += 10; //Assigns a value of 10 to playerHand
            } else if (playerCard == 12) {
                System.out.println("Your card is a QUEEN!");
                playersHand += 10;
            } else if (playerCard == 11) {
                System.out.println("Your card is a JACK!");
                playersHand += 10;
            } else if (playerCard == 1) {
                System.out.println("Your card is a ACE!");
                playersHand += 1;
            } else {
                System.out.println("Your card is a" + playerCard + "!");
                playersHand += playerCard;
            }

            System.out.println("Your hand is: " + playersHand);

            boolean gameContinue = true;
            while (gameContinue) { //Secondary loop for the menu
                System.out.println("");
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit\n");

                System.out.print("Choose an option: ");
                menuSelect = scnr.nextInt();
                System.out.println("");

                switch (menuSelect) { //Switch statement to allow the player to choose options from the menu

                    case 1: //Option 1: Get another card
                         playerCard = generateCards.nextInt(13) + 1;

                        if (playerCard == 13) {
                            System.out.println("Your card is a KING!");
                            playersHand += 10;
                        } else if (playerCard == 12) {
                            System.out.println("Your card is a QUEEN!");
                            playersHand += 10;
                        } else if (playerCard == 11) {
                            System.out.println("Your card is a JACK!");
                            playersHand += 10;
                        } else if (playerCard == 1) {
                            System.out.println("Your card is a ACE!");
                            playersHand += 1;
                        } else {
                            System.out.println("Your card is a" + playerCard + "!");
                            playersHand += playerCard;
                        }

                        System.out.println("Your hand is: " + playersHand);

                        if (playersHand == 21) {
                            System.out.println("BLACKJACK! You win!\n");
                            System.out.println("");
                            playerWins++;
                            gameContinue = false;
                        } else if (playersHand > 21) {
                            System.out.println("You exceeded 21! You lose.\n");
                            dealerWins++;
                            gameContinue = false;
                        }

                        break;
                    case 2: //Option 2: Hold Hand
                        dealersHand = generateCards.nextInt(11) + 16;

                        System.out.println("Dealer's hand: " + dealersHand);
                        System.out.println("Your hand is: " + playersHand);
                        System.out.println();

                        if (dealersHand > playersHand && dealersHand <= 21) {
                            System.out.println("Dealer wins!\n");
                            dealerWins++;
                            gameContinue = false;
                        } else if (dealersHand == playersHand) {
                            System.out.println("It's a tie! No one wins!\n");
                            gameTied++;
                            gameContinue = false;
                        } else if (playersHand > dealersHand && playersHand < 21) {
                            System.out.println("You win!\n");
                            playerWins++;
                            gameContinue = false;
                        } else if (dealersHand > 21) {
                            System.out.println("You win!\n");
                            playerWins++;
                            gameContinue = false;
                        } else if (playersHand > 21){
                            System.out.println("Dealer wins!\n");
                            dealerWins++;
                            gameContinue = false;
                        }else if(playersHand == 21) {
                            System.out.println("Black Jack! You win!\n");
                            playerWins++;
                            gameContinue = false;
                        }

                        break;

                    case 3: //Option 3: Print game stats
                        System.out.println("Number of Player wins: " + playerWins);
                        System.out.println("Number of Dealer wins: " + dealerWins);
                        System.out.println("Number of tie games: " + gameTied);
                        System.out.println("Total # of games played is: " + (gamesPlayed-2));

                        double winningPercentage =  ((double)playerWins/(gamesPlayed -2)) * 100; //Calculating win percentage and changing INT to DOUBLE
                        System.out.println("Percentage of Player wins: " + winningPercentage +"%");
                        break;

                    case 4: //Case 4 allows player to exit out of the game;
                        gameContinue = false;
                        letsPlay = false;
                        break;

                    default: //For any value selected that not 1,2,3,4
                        System.out.println("Invalid input!");
                        System.out.println("Please enter an integer value between 1 and 4.");
                        break;


                }
            }


        }
    }
}
