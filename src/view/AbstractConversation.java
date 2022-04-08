package src.view;


/**
 *  @param <C> Type of executed commands
 * @param <S> Type of stored state (commands or mementos)
 */
public abstract class AbstractConversation<C extends Command, S> implements Conversation<C> {
    protected final Stack<S> undos, redos;

    public AbstractConversation() {
        this.undos= new Stack<S>();
        this.redos= new Stack<S>();
    }
}
   // AbstractConversation utilise la classe Stack (classe interne au framework):

