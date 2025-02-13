import java.util.ArrayList;
import java.util.List;

public class BasicPrinterAdapter implements AdvancedPrinterInterface {
    private BasicPrinter printer = new BasicPrinter();
    private List<PrintJob> queuedJobs = new ArrayList<PrintJob>();
    private int jobId = 0;
    private List<Integer> jobIds = new ArrayList<Integer>();

    public BasicPrinterAdapter(BasicPrinter printer) {
        this.printer = printer;

    }
    public int print(Document doc) {
        String[] lines = doc.getContent().split("\\n"); // Split the document content by new lines.
        PrintJob job = new PrintJob(doc, jobId);

        if (printer.print(lines)) {
            queuedJobs.add(job);
            jobIds.add(jobId++);
            return jobId; // Return current jobId and increment it for the next job.
        } else {
            printer.refill();
            return -1; // Indicate failure to print.
        }
    }
    
    public List<Integer> print(List<Document> docs) {
        System.out.println("Spooling " + docs.size() + " documents.");
        for (Document doc : docs) {
            print(doc);
            queuedJobs.add(new PrintJob(doc, jobId));
            jobId++;
            jobIds.add(jobId);
        }
        return jobIds;
    }
    public void showQueuedJobs() {
        if (queuedJobs.isEmpty()) {
            System.out.println("No spooled jobs");
            return;
        }
        for (PrintJob job : queuedJobs) {
            System.out.println("* Job" + job.getJobId());
        }
    }

    public boolean cancelJob(int jobId) {
        for (PrintJob job : queuedJobs) {
            if (job.getJobId() == jobId) {
                queuedJobs.remove(job);
                jobIds.remove(jobId);
                System.out.println("Job" + jobId + " cancelled");
                return true;
            }
        }
        return false;
    }
    public void cancelAll() {
        queuedJobs.clear();
        jobIds.clear();
    }
}
