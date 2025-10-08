

public final class Grade {

    private String subject;
    private Score score;
    public enum Score {A, B, C, D, E, F}

    private Grade(Builder builder){
        this.subject = builder.subject;
        this.score = builder.score;
    }

    public String getSubject(){ return subject;}
    public Score getScore(){ return score;}

    public static final class Builder{
        private String subject;
        private Score score;

        private Builder(){}

        public Builder subject(String subject){
            this.subject = subject;
            return this;
        }

        public Builder score(Score score){
            this.score = score;
            return this;
        }

        public Grade build(){
            if (subject == null || subject.isBlank()){
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
        return "Grade for '%s' is: %s".formatted(subject, score);
    }
    
}
