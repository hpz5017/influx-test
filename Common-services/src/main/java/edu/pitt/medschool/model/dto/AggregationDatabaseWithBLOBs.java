package edu.pitt.medschool.model.dto;

public class AggregationDatabaseWithBLOBs extends AggregationDatabase {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column aggregation_database.pid_list
	 * @mbg.generated
	 */
	private String pidList;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column aggregation_database.columns
	 * @mbg.generated
	 */
	private String columns;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column aggregation_database.pid_list
	 * @return  the value of aggregation_database.pid_list
	 * @mbg.generated
	 */
	public String getPidList() {
		return pidList;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column aggregation_database.pid_list
	 * @param pidList  the value for aggregation_database.pid_list
	 * @mbg.generated
	 */
	public void setPidList(String pidList) {
		this.pidList = pidList == null ? null : pidList.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column aggregation_database.columns
	 * @return  the value of aggregation_database.columns
	 * @mbg.generated
	 */
	public String getColumns() {
		return columns;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column aggregation_database.columns
	 * @param columns  the value for aggregation_database.columns
	 * @mbg.generated
	 */
	public void setColumns(String columns) {
		this.columns = columns == null ? null : columns.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aggregation_database
	 * @mbg.generated
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		AggregationDatabaseWithBLOBs other = (AggregationDatabaseWithBLOBs) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getDbName() == null ? other.getDbName() == null : this.getDbName().equals(other.getDbName()))
				&& (this.getVersion() == null ? other.getVersion() == null
						: this.getVersion().equals(other.getVersion()))
				&& (this.getAggregateTime() == null ? other.getAggregateTime() == null
						: this.getAggregateTime().equals(other.getAggregateTime()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null
						: this.getCreateTime().equals(other.getCreateTime()))
				&& (this.getMean() == null ? other.getMean() == null : this.getMean().equals(other.getMean()))
				&& (this.getMax() == null ? other.getMax() == null : this.getMax().equals(other.getMax()))
				&& (this.getMin() == null ? other.getMin() == null : this.getMin().equals(other.getMin()))
				&& (this.getSd() == null ? other.getSd() == null : this.getSd().equals(other.getSd()))
				&& (this.getMedian() == null ? other.getMedian() == null : this.getMedian().equals(other.getMedian()))
				&& (this.getQ1() == null ? other.getQ1() == null : this.getQ1().equals(other.getQ1()))
				&& (this.getQ3() == null ? other.getQ3() == null : this.getQ3().equals(other.getQ3()))
				&& (this.getSum() == null ? other.getSum() == null : this.getSum().equals(other.getSum()))
				&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
				&& (this.getTotal() == null ? other.getTotal() == null : this.getTotal().equals(other.getTotal()))
				&& (this.getFinished() == null ? other.getFinished() == null
						: this.getFinished().equals(other.getFinished()))
				&& (this.getAutoUpdate() == null ? other.getAutoUpdate() == null
						: this.getAutoUpdate().equals(other.getAutoUpdate()))
				&& (this.getArtype() == null ? other.getArtype() == null : this.getArtype().equals(other.getArtype()))
				&& (this.getFromDb() == null ? other.getFromDb() == null : this.getFromDb().equals(other.getFromDb()))
				&& (this.getTimeCost() == null ? other.getTimeCost() == null
						: this.getTimeCost().equals(other.getTimeCost()))
				&& (this.getThreads() == null ? other.getThreads() == null
						: this.getThreads().equals(other.getThreads()))
				&& (this.getParts() == null ? other.getParts() == null : this.getParts().equals(other.getParts()))
				&& (this.getNday() == null ? other.getNday() == null : this.getNday().equals(other.getNday()))
				&& (this.getPidList() == null ? other.getPidList() == null
						: this.getPidList().equals(other.getPidList()))
				&& (this.getColumns() == null ? other.getColumns() == null
						: this.getColumns().equals(other.getColumns()));
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aggregation_database
	 * @mbg.generated
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getDbName() == null) ? 0 : getDbName().hashCode());
		result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
		result = prime * result + ((getAggregateTime() == null) ? 0 : getAggregateTime().hashCode());
		result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result + ((getMean() == null) ? 0 : getMean().hashCode());
		result = prime * result + ((getMax() == null) ? 0 : getMax().hashCode());
		result = prime * result + ((getMin() == null) ? 0 : getMin().hashCode());
		result = prime * result + ((getSd() == null) ? 0 : getSd().hashCode());
		result = prime * result + ((getMedian() == null) ? 0 : getMedian().hashCode());
		result = prime * result + ((getQ1() == null) ? 0 : getQ1().hashCode());
		result = prime * result + ((getQ3() == null) ? 0 : getQ3().hashCode());
		result = prime * result + ((getSum() == null) ? 0 : getSum().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
		result = prime * result + ((getFinished() == null) ? 0 : getFinished().hashCode());
		result = prime * result + ((getAutoUpdate() == null) ? 0 : getAutoUpdate().hashCode());
		result = prime * result + ((getArtype() == null) ? 0 : getArtype().hashCode());
		result = prime * result + ((getFromDb() == null) ? 0 : getFromDb().hashCode());
		result = prime * result + ((getTimeCost() == null) ? 0 : getTimeCost().hashCode());
		result = prime * result + ((getThreads() == null) ? 0 : getThreads().hashCode());
		result = prime * result + ((getParts() == null) ? 0 : getParts().hashCode());
		result = prime * result + ((getNday() == null) ? 0 : getNday().hashCode());
		result = prime * result + ((getPidList() == null) ? 0 : getPidList().hashCode());
		result = prime * result + ((getColumns() == null) ? 0 : getColumns().hashCode());
		return result;
	}
}