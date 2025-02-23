package be.kdg.domain.tool;

import java.util.Date;

public class ExpertReview {

    private double estimatedValue;
    private int sharepointsPerDay;
    private String expertiseReport;
    private Date evaluationDate;

    public ExpertReview(double estimatedValue, int sharepointsPerDay, String expertiseReport, Date evaluationDate) {
        this.estimatedValue = estimatedValue;
        this.sharepointsPerDay = sharepointsPerDay;
        this.expertiseReport = expertiseReport;
        this.evaluationDate = evaluationDate;
    }

    public double getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(double estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    public int getSharepointsPerDay() {
        return sharepointsPerDay;
    }

    public void setSharepointsPerDay(int sharepointsPerDay) {
        this.sharepointsPerDay = sharepointsPerDay;
    }

    public String getExpertiseReport() {
        return expertiseReport;
    }

    public void setExpertiseReport(String expertiseReport) {
        this.expertiseReport = expertiseReport;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }
}

