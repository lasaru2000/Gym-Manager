public class DefaultMember {

    private String memberName;
    private int memberNumber;
    private String membershipStartDate;

    public DefaultMember(String memberName, int membershipNumber, String membershipStartDate){
        super();
        this.memberName = memberName;
        this.memberNumber = membershipNumber;
        this.membershipStartDate = membershipStartDate;
    }



    public String getMemberName() {

        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getMembershipNumber() {
        return memberNumber;
    }

    public void setMembershipNumber(int membershipNumber) {
        this.memberNumber = membershipNumber;
    }

    public String getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(String membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }
}


