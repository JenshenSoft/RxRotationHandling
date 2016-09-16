package com.handing.rxrotation.jenshen.rxrotationhandling.exampl;

import com.github.partition.nonconfscope.repos.Repo;

import java.util.List;

interface MyReposView {
  void setRepos(List<Repo> repos);
  void displayError();
}
