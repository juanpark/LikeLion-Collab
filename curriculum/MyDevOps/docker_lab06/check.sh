#!/bin/bash
kubectl exec -it q1-emptydir-pod -- cat /shared/hello.txt
kubectl exec -it q2-hostpath-pod -- cat /host/hello-host.txt
kubectl exec -it q3-pvc-pod -- cat /data/persistent.txt
kubectl exec -it q4-nfs-pod -- ls /mnt
kubectl exec -it q5-configmap-pod -- cat /etc/html/index.html
kubectl exec -it q6-secret-pod -- printenv PASSWORD
