#!/bin/bash
kubectl delete -f Q1_emptydir.yaml
kubectl delete -f Q2_hostpath.yaml
kubectl delete -f Q3_pvc.yaml
kubectl delete -f Q4_nfs.yaml
kubectl delete -f Q5_configmap.yaml
kubectl delete -f Q6_secret.yaml
