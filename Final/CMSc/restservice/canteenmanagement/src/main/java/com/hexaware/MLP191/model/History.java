
package com.hexaware.MLP191.model;

/**
 * History class used to display History information.
 * @author Santhosh-hexware
 */
public class History {
  private int rating;
  private String feedback;
  private int cusId;
  private int ordId;

  /**
   */
  public History() {
  }

  /**
   * @param argrating rating
   * @param argfeedback feedback
   * @param argcusId id
   * @param argordId order id
   */
  public History(final int argrating, final String argfeedback, final int argcusId, final int argordId) {
    this.rating = argrating;
    this.feedback = argfeedback;
    this.cusId = argcusId;
    this.ordId = argordId;
  }

  /**
   * @return the rating
   */
  public final int getRating() {
    return rating;
  }

  /**
   * @param argrating the rating to set
   */
  public final void setRating(final int argrating) {
    this.rating = argrating;
  }

  /**
   * @return the feedback
   */
  public final String getFeedback() {
    return feedback;
  }

  /**
   * @param argfeedback the feedback to set
   */
  public final void setFeedback(final String argfeedback) {
    this.feedback = argfeedback;
  }

  /**
   * @return the cusId
   */
  public final int getCusId() {
    return cusId;
  }

  /**
   * @param argcusId the cusId to set
   */
  public final void setCusId(final int argcusId) {
    this.cusId = argcusId;
  }

  /**
   * @return the ordId
   */
  public final int getOrdId() {
    return ordId;
  }

  /**
   * @param argordId the ordId to set
   */
  public final void setOrdId(final int argordId) {
    this.ordId = argordId;
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */

  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + cusId;
    //result = prime * result + ((feedback == null) ? 0 : feedback.hashCode());
    result = prime * result + ordId;
    result = prime * result + rating;
    return result;
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public final boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof History)) {
      return false;
    }
    History other = (History) obj;
    if (cusId != other.cusId) {
      return false;
    }
    if (feedback == null) {
      if (other.feedback != null) {
        return false;
      }
    } else if (!feedback.equals(other.feedback)) {
      return false;
    }
    if (ordId != other.ordId) {
      return false;
    }
    if (rating != other.rating) {
      return false;
    }
    return true;
  }
  /*
   * (non-Javadoc)
   * @see java.lang.Object#toString()
   */
/*
  @Override
  public final String toString() {
    return "History [cusId=" + cusId + ", feedback=" + feedback + ", ordId=" + ordId + ", rating=" + rating + "]";
  } */

}
