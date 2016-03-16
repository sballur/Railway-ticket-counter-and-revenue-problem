package com.sb.InventoryManagement;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	int numberOfTickets, firstMTicketsToSell;
	int[] ticketsPerWindow;
	
	public Solution(int numberOfTickets, int firstMTicketsToSell, int[] ticketsPerWindow)
	{
		this.numberOfTickets = numberOfTickets;
		this.firstMTicketsToSell = firstMTicketsToSell;
		this.ticketsPerWindow = ticketsPerWindow;
	}
	
	public int findMaximumRevenue()
	{
		int[] windows = this.ticketsPerWindow;
		Arrays.sort(windows);
		int i = windows.length-1;
		int revenue = 0;
		int prevWindow = 0;
		int currentWindow = 0;
		while(i >= 0 && this.firstMTicketsToSell != 0)
		{
			currentWindow = windows[i];
			if (i == 0) {
				prevWindow = 0;
			} else {
				prevWindow = windows[i - 1];
			}

			if (currentWindow == prevWindow) {
				revenue += currentWindow;
				this.firstMTicketsToSell--;
				if (this.firstMTicketsToSell > 0) {
					revenue += prevWindow;
					this.firstMTicketsToSell--;
				}
			} else {
				while (currentWindow > prevWindow && this.firstMTicketsToSell != 0) {
					revenue += currentWindow;
					currentWindow--;
					this.firstMTicketsToSell--;
				}
			}
			i--;

		}
		return revenue;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int numberOfTickets = sc.nextInt();
		int firstMTicketsToSell = sc.nextInt();
		int perBooth[] = new int[numberOfTickets];
		for(int i = 0; i < numberOfTickets; i++)
		{
			perBooth[i] = sc.nextInt();
		}
		Solution rt = new Solution(numberOfTickets, firstMTicketsToSell, perBooth);
		System.out.println("Max Revenue = " + rt.findMaximumRevenue());
	}
}
