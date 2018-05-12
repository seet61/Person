public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public void setSpouse(Person person) {
        this.spouse = person;
    }

    public Person getSpouse() {
        return this.spouse;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife.
     * Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        if (this.man != person.man) {
            if (this.spouse == null && person.getSpouse() == null) {
                this.spouse = person;
                person.setSpouse(this);
                return true;
            } else if (this.spouse != null && person.getSpouse() != null) {
                // if one or both married
                if (this.spouse != null) {
                    this.spouse.divorce();
                    this.divorce();
                }
                if (person.getSpouse() != null) {
                    person.getSpouse().divorce();
                    person.divorce();
                }
                this.marry(person);
            }
            return false;
        }
        return false;
    }

    /**
     * Sets spouse = null if spouse is not null
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        if (this.spouse != null) {
            this.spouse = null;
            return true;
        } else {
            return false;
        }
    }
}