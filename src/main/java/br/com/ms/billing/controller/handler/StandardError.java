package br.com.ms.billing.controller.handler;

import java.time.LocalDateTime;

public class StandardError {

    private Integer status;
    private String mensagem;
    private LocalDateTime timeStamp;

    public StandardError(Integer status, String mensagem, LocalDateTime timeStamp) {
        this.status = status;
        this.mensagem = mensagem;
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public static StandardError valueOf(Integer status, String mensagem, LocalDateTime timeStamp){
        return new StandardError(status, mensagem, timeStamp);
    }
}
