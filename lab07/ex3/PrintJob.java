public class PrintJob implements Runnable {
    private final Document document;
    private final int jobId;

    public PrintJob(Document document, int jobId) {
        this.document = document;
        this.jobId = jobId;
    }

    @Override
    public void run() {
        System.out.println(jobId);
        try {
            Thread.sleep(1000); // simulate the time taken to print
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Printing interrupted for job " + jobId);
        }
    }

    public Document getDocument() {
        return document;
    }

    public int getJobId() {
        return jobId;
    }
}
