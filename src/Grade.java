

public final class Grade {

    private String courseName;
    private String courseSubject;
    private Score score;
    public enum Score {A, B, C, D, E, F}

    private Grade(Builder builder){
        this.courseName = builder.courseName;
        this.courseSubject = builder.courseSubject;
        this.score = builder.score;
    }

    public String getCourseName(){ return courseName;}
    public String getCourseSubject(){ return courseSubject;}
    public Score getScore(){ return score;}

    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder{
        private String courseName;
        private String courseSubject;
        private Score score;

        private Builder(){}

        public Builder courseName(String cName){
            this.courseName = cName;
            return this;
        }

        public Builder courseSubject(String cSubject){
            this.courseSubject = cSubject;
            return this;
        }

        public Builder score(Score scr){
            this.score = scr;
            return this;
        }

        public Grade build(){
            if (courseName == null || courseName.isBlank()){
                throw new IllegalStateException("⚠️ Course name must be provided");
            }
            if (courseSubject == null || courseSubject.isBlank()){
                throw new IllegalStateException("⚠️ Subject must be provided");
            }
            if (score == null ){
                throw new IllegalStateException("⚠️ Score must be provided");
            }

            return new Grade(this);
        }
    }

    @Override
    public String toString(){
        return "grade for course '%s', in the subject '%s' is: %s".formatted(courseName, courseSubject, score);
    }
    
}
