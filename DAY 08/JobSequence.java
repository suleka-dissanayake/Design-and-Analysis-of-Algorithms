class Job {
    String id;
    int deadline, profit;

    public Job(String id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class JobSequence {
    static void sortJobs(Job[] jobs, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (jobs[j].profit < jobs[j + 1].profit) {
                    Job temp = jobs[j];
                    jobs[j] = jobs[j + 1];
                    jobs[j + 1] = temp;
                }
            }
        }
    }

    static void scheduleJobs(Job[] jobs, int n) {
        sortJobs(jobs, n);

        int maxD = 0;
        for (int i = 0; i < n; i++) {
            if (jobs[i].deadline > maxD)
                maxD = jobs[i].deadline;
        }

        String[] result = new String[maxD];
        boolean[] filled = new boolean[maxD];

        int totalProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int k = jobs[i].deadline - 1; k >= 0; k--) {
                if (!filled[k]) {
                    result[k] = jobs[i].id;
                    filled[k] = true;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }

        System.out.println("Job Sequence:");
        for (int i = 0; i < maxD; i++) {
            if (result[i] != null)
                System.out.print(result[i] + " ");
        }

        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {

        Job[] jobs = {
            new Job("J1", 5, 200),
            new Job("J2", 3, 180),
            new Job("J3", 3, 190),
            new Job("J4", 2, 300),
            new Job("J5", 4, 120),
            new Job("J6", 2, 100)
        };

        int n = jobs.length;

        scheduleJobs(jobs, n);
    }
}