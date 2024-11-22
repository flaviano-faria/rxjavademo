package com.rxjava.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RxJavaDemoController {

	@PostMapping("/test")
	public String testRxJava(@RequestBody String message) {
		Observable.create(s -> {
			s.onNext(message);
			s.onComplete();
			}).subscribe(hello -> System.out.println(hello));
		
		return message;
	}
	
}
