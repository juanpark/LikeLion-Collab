# Kubernetes Volume 실습 (Q1 ~ Q6)

## 사용법
```bash
kubectl apply -f Q1_emptydir.yaml
kubectl exec -it q1-emptydir-pod -- cat /shared/hello.txt

kubectl apply -f Q2_hostpath.yaml
kubectl exec -it q2-hostpath-pod -- cat /host/hello-host.txt

kubectl apply -f Q3_pvc.yaml
kubectl exec -it q3-pvc-pod -- cat /data/persistent.txt

kubectl apply -f Q4_nfs.yaml
kubectl exec -it q4-nfs-pod -- ls /mnt

kubectl apply -f Q5_configmap.yaml
kubectl exec -it q5-configmap-pod -- cat /etc/html/index.html

kubectl apply -f Q6_secret.yaml
kubectl exec -it q6-secret-pod -- printenv PASSWORD
```

## 정리
```bash
kubectl delete -f Q1_emptydir.yaml
kubectl delete -f Q2_hostpath.yaml
kubectl delete -f Q3_pvc.yaml
kubectl delete -f Q4_nfs.yaml
kubectl delete -f Q5_configmap.yaml
kubectl delete -f Q6_secret.yaml
```
